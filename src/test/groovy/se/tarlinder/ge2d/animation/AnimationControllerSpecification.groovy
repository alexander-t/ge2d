package se.tarlinder.ge2d.animation

import spock.lang.Specification

class AnimationControllerSpecification extends Specification {
    def "Idle animations restart, even if they're non-looping"() {
        given:
        def idleAnimation = new Animation("idle", false)
        idleAnimation.addStep("one", 10)

        def controller = new AnimationController(idleAnimation)

        when:
        controller.start()

        then:
        controller.getAnimation().spriteId == "one"

        and:
        Thread.sleep(45)
        controller.update()

        then:
        controller.getAnimation().spriteId == "one"

        and:
        Thread.sleep(45)
        controller.update()

        then:
        controller.getAnimation().spriteId == "one"
    }
}
