package se.tarlinder.ge2d.animation;

import se.tarlinder.ge2d.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Primitive controller that's able to toggle between a moving and an idle animation.
 */
public class AnimationController extends Component {

    private List<Animation> animations = new ArrayList<>();

    private Animation idleAnimation;
    private Animation currentAnimation;

    public AnimationController(Animation idleAnimation) {
        this.idleAnimation = idleAnimation;
        currentAnimation = idleAnimation;
    }

    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    public void setCurrentAnimation(String id) {
        currentAnimation = animations.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        currentAnimation.start();
    }

    public void setIdleAnimation() {
        currentAnimation = idleAnimation;
        currentAnimation.start();
    }

    public Animation getAnimation() {
        // If no animation is playing. Restart the idle animation
        if (!currentAnimation.isPlaying()) {
            currentAnimation = idleAnimation;
            currentAnimation.start();
        }
        return currentAnimation;
    }

    @Override
    public void start() {
        currentAnimation.start();
    }

    @Override
    public void update() {
        currentAnimation.update();
    }
}

