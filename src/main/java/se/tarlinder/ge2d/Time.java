package se.tarlinder.ge2d;

/**
 * Used by the engine to provide a time delta.
 */
public class Time {

    private static long previousFrameTime;
    private static long currentFrameTime;

    public static void update(long now) {
        previousFrameTime = currentFrameTime;
        currentFrameTime = now;
    }
    public static float deltaTime() {
        return (currentFrameTime - previousFrameTime) / 1000.0f;
    }
}
