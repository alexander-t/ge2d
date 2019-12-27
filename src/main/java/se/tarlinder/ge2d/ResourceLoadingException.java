package se.tarlinder.ge2d;

/**
 * Thrown to indicate that a resource couldn't be loaded.
 */
public class ResourceLoadingException extends RuntimeException {
    public ResourceLoadingException(Exception reason) {
        super(reason);
    }
}
