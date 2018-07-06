package io.chrislowe.tincan.objects.ui

import io.chrislowe.tincan.*
import io.chrislowe.tincan.objects.GameObject
import kotlin.math.sin

class EndMessage(hasHighScore: Boolean) : GameObject() {
    private val bobAmount = 64

    private var ticksAlive = 0

    init {
        val imageName = if (hasHighScore) "congrats.png" else "tryagain.png"
        setTexture(imageName)

        sprite.setScale((TinCanGame.gameWidth / sprite.width) * 0.85f)
        sprite.x = TinCanGame.gameWidth / 2f - sprite.width / 2f
        sprite.y = 2f * (TinCanGame.gameHeight - sprite.height) / 3f
    }

    override fun update() {
        super.update()

        ticksAlive++

        val screenMiddle = TinCanGame.gameHeight / 3f
        val fps = TinCanGame.fps.toFloat()
        val sinePosition = sin(Math.PI * (ticksAlive / fps)).toFloat()

        sprite.y = screenMiddle + sinePosition * bobAmount
    }
}