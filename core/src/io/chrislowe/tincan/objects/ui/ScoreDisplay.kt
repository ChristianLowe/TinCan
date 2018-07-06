package io.chrislowe.tincan.objects.ui

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import io.chrislowe.tincan.Director
import io.chrislowe.tincan.TinCanGame
import io.chrislowe.tincan.objects.GameObject

class ScoreDisplay : GameObject() {
    private val currentScoreText = "CURR %04d   "
    private val highScoreText = "   HIGH %04d"

    private val whiteLabelStyle: Label.LabelStyle
    private val goldLabelStyle: Label.LabelStyle

    private val currentScoreLabel: Label
    private val highScoreLabel: Label

    init {
        whiteLabelStyle = Label.LabelStyle(TinCanGame.textFont, Color.WHITE)
        goldLabelStyle = Label.LabelStyle(TinCanGame.textFont, Color.GOLD)

        currentScoreLabel = Label(currentScoreText, whiteLabelStyle)
        currentScoreLabel.setSize(TinCanGame.gameWidth, currentScoreLabel.height)
        currentScoreLabel.setAlignment(Align.right)
        currentScoreLabel.setPosition(0f, TinCanGame.gameHeight - currentScoreLabel.height * 2f)

        highScoreLabel = Label(highScoreText, whiteLabelStyle)
        highScoreLabel.setSize(TinCanGame.gameWidth, highScoreLabel.height)
        highScoreLabel.setAlignment(Align.left)
        highScoreLabel.setPosition(0f, TinCanGame.gameHeight - highScoreLabel.height * 2f)
    }

    override fun draw(batch: SpriteBatch) {
        currentScoreLabel.setText(String.format(currentScoreText, Director.gameScore))
        highScoreLabel.setText(String.format(highScoreText, Director.highScore))

        if (Director.hasHighScore) highScoreLabel.style = goldLabelStyle

        currentScoreLabel.draw(batch, 1f)
        highScoreLabel.draw(batch, 1f)
    }
}