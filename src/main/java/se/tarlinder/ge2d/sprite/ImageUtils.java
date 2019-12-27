package se.tarlinder.ge2d.sprite;

import se.tarlinder.ge2d.ResourceLoadingException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

/**
 * Helper class that loads an image from the resources or a file. Note that BufferedImage is used consistently
 * through the interface. While it's a concrete implementation; it's the one we want and it has subImage, so the
 * interface has been made consistent.
 */
public class ImageUtils {
    public static BufferedImage loadImageResource(String resourcePath) {
        try {
            return ImageIO.read(ImageUtils.class.getResourceAsStream(resourcePath));
        } catch (IOException e) {
            throw new ResourceLoadingException(e);
        }
    }

    public static BufferedImage loadImageFile(File imageFile) {
        try {
            return ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new ResourceLoadingException(e);
        }
    }

    /**
     * Flips the image horizontally. Used to get mirrored sprites.
     *
     * @param srcImage image to mirror
     * @return the image flipped along the y-axis, i.e. mirrored
     */
    public static BufferedImage flipImage(BufferedImage srcImage) {
        AffineTransform transform = AffineTransform.getScaleInstance(-1, 1);
        transform.translate(-srcImage.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(srcImage, null);
    }

    /**
     * Makes a color transparent by zeroing the alpha bits. Present value of those bits is ignored.
     *
     * @param srcImage       source image
     * @param colorToReplace color to make transparent
     * @return image new image
     */
    public static BufferedImage makeColorTransparent(BufferedImage srcImage, Color colorToReplace) {
        ImageFilter filter = new RGBImageFilter() {
            public final int filterRGB(int x, int y, int rgb) {
                return (rgb | 0xFF000000) == colorToReplace.getRGB() ? rgb & 0x00FFFFFF : rgb;
            }
        };

        return toBufferedImage(Toolkit.getDefaultToolkit()
                .createImage(new FilteredImageSource(srcImage.getSource(), filter)));
    }

    /**
     * Converts an <code>Image</code> to a <code>BufferedImage</code>. This seems to be the de facto solution
     * from the net.
     * @param srcImage image to convert
     * @return a BufferedImage
     */
    public static BufferedImage toBufferedImage(Image srcImage) {
        if (srcImage instanceof BufferedImage) {
            return (BufferedImage) srcImage;
        }

        BufferedImage bi = new BufferedImage(srcImage.getWidth(null), srcImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bi.createGraphics();
        graphics.drawImage(srcImage, 0, 0, null);
        graphics.dispose();
        return bi;
    }

}
