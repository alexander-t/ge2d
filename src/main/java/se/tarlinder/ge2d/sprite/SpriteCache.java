package se.tarlinder.ge2d.sprite;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class SpriteCache {

    private static Map<String, SpriteSheet> sheets = new HashMap<>();
    private static Map<String, BufferedImage> sprites = new HashMap<>();

    public static void addSheet(String id, SpriteSheet sheet) {
        sheets.put(id, sheet);
    }

    public static void addImage(String id, String resourcePath) {
        sprites.put(id, ImageUtils.loadImageResource(resourcePath));
    }

    public static void add(String id, BufferedImage image) {
        sprites.put(id, image);
    }

    public static void addFlipped(String newId, String existingId) {
        sprites.put(newId, ImageUtils.flipImage(get(existingId)));
    }

    public static BufferedImage get(String id) {
        return sprites.getOrDefault(id, null);
    }
}
