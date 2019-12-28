package se.tarlinder.ge2d.animation;

import se.tarlinder.ge2d.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * An animation composed of multiple steps with their own durations.
 * Animations are loosely coupled to sprites and store the sprite id only.
 */
public class Animation extends Component {

    private List<AnimationStep> steps = new ArrayList<>();

    private String id;
    private boolean looping;
    private long totalDuration;

    private boolean playing;
    private long startTime = -1;
    private long elapsed;

    public Animation(String id, boolean looping) {
        this.id = id;
        this.looping = looping;
    }

    public void addStep(String spriteId, long durationInMs) {
        long startTime = 0;
        if (!steps.isEmpty()) {
            AnimationStep lastStep = steps.get(steps.size() - 1);
            startTime = lastStep.startTime + lastStep.duration + 1;
        }
        steps.add(new AnimationStep(spriteId, startTime, durationInMs));
        totalDuration += durationInMs;
    }

    @Override
    public void start() {
        startTime = System.currentTimeMillis();
        playing = true;
    }

    @Override
    public void update() {
        if (playing) {
            elapsed = System.currentTimeMillis() - startTime;
            if (elapsed > totalDuration) {
                if (looping) {
                    startTime = System.currentTimeMillis();
                    elapsed = 0;
                } else {
                    playing = false;
                    // Just to be extra clear
                    elapsed = totalDuration;
                }
            }
        }
    }

    public String getId() {
        return id;
    }

    public boolean isPlaying() {
        return playing;
    }

    public String getSpriteId() {
        if (!playing) {
            return null;
        }

        return steps.stream().filter(s -> elapsed >= s.startTime && elapsed <= s.startTime + s.duration).findFirst().get().spriteId;
    }

    private static class AnimationStep {
        private String spriteId;
        private long startTime;
        private long duration;

        public AnimationStep(String spriteId, long startTime, long duration) {
            this.spriteId = spriteId;
            this.startTime = startTime;
            this.duration = duration;
        }
    }
}
