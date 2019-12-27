package se.tarlinder.ge2d;

import se.tarlinder.ge2d.input.KeyAdapterInputHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Engine {
    private List<Entity> entities = new ArrayList<>();
    private JFrame window;

    public Engine(JFrame window) {
        this.window = window;
        window.addKeyListener(new KeyAdapterInputHandler());
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    /**
     * Starts a fixed-step game loop that updates all registered entities and their components.
     */
    public void startGameLoop() {
        new Thread(() -> {
            final long MS_PER_UPDATE = 10;
            for (Entity entity : entities) {
                for (Component component : entity.components) {
                    component.start();
                }
            }

            long currentTime;
            long previousTime = System.currentTimeMillis();
            long lag = 0;
            long elapsedTime;

            while (true) {
                currentTime = System.currentTimeMillis();
                elapsedTime = currentTime - previousTime;
                previousTime = currentTime;
                lag += elapsedTime;

                while (lag > MS_PER_UPDATE) {
                    Time.update(currentTime);
                    for (Entity entity : entities) {
                        for (Component component : entity.components) {
                            component.update();
                        }
                    }
                    lag -= MS_PER_UPDATE;
                }

                window.repaint();
            }
        }).start();
    }

    public void render(Graphics g) {
        for (Entity entity : entities) {
            entity.render(g);
        }
    }
}
