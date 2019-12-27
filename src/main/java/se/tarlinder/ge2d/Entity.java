package se.tarlinder.ge2d;

import se.tarlinder.ge2d.animation.AnimationController;
import se.tarlinder.ge2d.sprite.SpriteCache;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A temporary approach to entities. There's an x and y and animation is funky.
 */
public class Entity {
    public int x, y;
    public List<Component> components = new ArrayList<>();

    public void addComponent(Component component) {
        component.setOwner(this);
        components.add(component);
    }

    public Component getComponent(Class componentClass) {
        return components.stream().filter(c -> componentClass.isInstance(c)).findAny().orElse(null);
    }

    public void render(Graphics g) {
        AnimationController animationController = (AnimationController) getComponent(AnimationController.class);
        if (animationController != null) {
            g.drawImage(SpriteCache.get(animationController.getAnimation().getSpriteId()), x, y, null);
        }
    }
}
