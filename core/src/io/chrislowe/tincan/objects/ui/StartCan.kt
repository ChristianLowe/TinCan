package io.chrislowe.tincan.objects.ui

import io.chrislowe.tincan.Audio
import io.chrislowe.tincan.Director
import io.chrislowe.tincan.TinCanGame
import io.chrislowe.tincan.objects.GameObject
import kotlin.math.sin

class StartCan : GameObject() {
    private val bobAmount = 64

    private var ticksAlive = 0

    init {
        setTexture("can0.png")

        sprite.x = TinCanGame.gameWidth / 2f - sprite.width / 2f
        sprite.y = TinCanGame.gameHeight / 2f
    }

    override fun update() {
        super.update()

        ticksAlive++

        val screenMiddle = TinCanGame.gameWidth / 2f - sprite.width / 2f
        val fps = TinCanGame.fps.toFloat()
        val sinePosition = sin(Math.PI * (ticksAlive / fps)).toFloat()

        sprite.x = screenMiddle + sinePosition * bobAmount
    }

    override fun touch(touchX: Float, touchY: Float) {
        Audio.playSound(Audio.SoundTag.HIT)
        Director.changeGameState(Director.GameState.PLAYING)
    }
}