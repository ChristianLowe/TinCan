package io.chrislowe.tincan.objects.ui

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import io.chrislowe.tincan.TinCanGame
import io.chrislowe.tincan.objects.GameObject

class Logo : GameObject() {
    private val copyrightText = "Software © 2018 Christian Lowe"
    private val copyrightX = 0f
    private val copyrightY = TinCanGame.gameHeight / 4f
    private val copyrightLabel: Label

    init {
        setTexture("logo.png")
        sprite.setScale((TinCanGame.gameWidth / sprite.width) * 0.85f)
        sprite.x = TinCanGame.gameWidth / 2f - sprite.width / 2f
        sprite.y = 2 * (TinCanGame.gameHeight - sprite.height) / 3f

        val labelStyle = Label.LabelStyle(TinCanGame.textFont, Color.WHITE)
        copyrightLabel = Label(copyrightText, labelStyle)
        copyrightLabel.setSize(TinCanGame.gameWidth, copyrightLabel.height)
        copyrightLabel.setAlignment(Align.center)
        copyrightLabel.setPosition(copyrightX, copyrightY)
    }

    override fun draw(batch: SpriteBatch) {
        super.draw(batch)
        copyrightLabel.draw(batch, 1f)
    }
}