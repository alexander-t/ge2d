package se.tarlinder.ge2d.animation;

import se.tarlinder.ge2d.Component;

/**
 * Primitive controller that's able to toggle between a moving and an idle animation.
 */
public class AnimationController extends Component {

    private Animation animation;
    private Animation idleAnimation;
    private Animation currentAnimation;

    public AnimationController(Animation animation, Animation idleAnimation) {
        this.animation = animation;
        this.idleAnimation = idleAnimation;
        currentAnimation = idleAnimation;
    }

    public void setIdle(boolean idle) {
        currentAnimation = idle == true ? idleAnimation : animation;
        currentAnimation.start();
    }

    public Animation getAnimation() {
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
