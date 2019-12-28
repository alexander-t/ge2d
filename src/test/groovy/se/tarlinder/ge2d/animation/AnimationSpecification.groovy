package se.tarlinder.ge2d.sprite

import se.tarlinder.ge2d.animation.Animation
import spock.lang.Specification

class AnimationSpecification extends Specification {

    def "Loop two cycles in a looping animation"() {
        given:
        def animation = new Animation("animation", true)
        animation.addStep("one", 100)
        animation.addStep("two", 100)
        when:
        animation.start()
        then:
        animation.getSpriteId() == "one"
        and:
        Thread.sleep(130)
        animation.update()
        then:
        animation.getSpriteId() == "two"
        and:
        Thread.sleep(130)
        animation.update()
        then:
        animation.getSpriteId() == "one"
        and:
        Thread.sleep(130)
        animation.update()
        then:
        animation.getSpriteId() == "two"
    }

    def "Traverse an entire non-looping animation chain"() {
        given:
        def animation = new Animation("animation", false)
        animation.addStep("one", 100)
        animation.addStep("two", 200)
        animation.addStep("three", 300)
        when:
        animation.start()
        then:
        animation.getSpriteId() == "one"
        and:
        Thread.sleep(150)
        animation.update()
        then:
        animation.getSpriteId() == "two"
        and:
        Thread.sleep(200)
        animation.update()
        then:
        animation.getSpriteId() == "three"
        and:
        Thread.sleep(350)
        animation.update()
        then:
        animation.getSpriteId() == null
    }
}
