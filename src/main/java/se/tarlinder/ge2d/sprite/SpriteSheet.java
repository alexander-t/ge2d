package se.tarlinder.ge2d.sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Models a sprite sheet from which individual sprites can be cut out.
 */
public class SpriteSheet {

    private Color transparentColor;
    private BufferedImage sheet;

    public SpriteSheet(String resourcePath) {
        sheet = ImageUtils.loadImageResource(resourcePath);
    }

    public void makeColorTransparent(Color transparentColor) {
        this.transparentColor = transparentColor;
        sheet = ImageUtils.makeColorTransparent(sheet, transparentColor);
    }

    public BufferedImage cutOut(int x, int y, int w, int h) {
        return sheet.getSubimage(x, y, w, h);
    }
}
