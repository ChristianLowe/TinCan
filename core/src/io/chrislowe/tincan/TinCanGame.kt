package io.chrislowe.tincan

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class TinCanGame(platformStoredData: StoredData) : ApplicationAdapter() {
    companion object {
        const val fps = 60
        const val gameWidth = 720f
        const val gameHeight = 1280f
        lateinit var storedData: StoredData
        lateinit var textFont: BitmapFont
    }

    private lateinit var camera: OrthographicCamera
    private lateinit var batch: SpriteBatch

    private val frameLifetime = 1000L / fps
    private var nextUpdate = 0L

    init {
        storedData = platformStoredData
    }

    override fun create() {
        camera = OrthographicCamera()
        camera.setToOrtho(false, gameWidth, gameHeight)
        camera.update()

        batch = SpriteBatch()
        batch.projectionMatrix = camera.combined

        textFont = BitmapFont(Gdx.files.internal("scorefont.fnt"))

        Gdx.input.inputProcessor = object : InputAdapter() {
            override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
                val scaleX = gameWidth / Gdx.app.graphics.width
                val scaleY = gameHeight / Gdx.app.graphics.height

                val touchX = screenX * scaleX
                val touchY = gameHeight - (screenY * scaleY)

                println("ScaleX: $scaleX, ScaleY: $scaleY")
                println("TouchX: $touchX, TouchY: $touchY")

                Director.handleTouchEvent(touchX, touchY)
                return true
            }
        }

        Audio.init()
    }

    override fun render() {
        update()

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        GameBackground.drawBackground(batch)
        Director.drawGameObjects(batch)
        batch.end()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun update() {
        val startTime = System.currentTimeMillis()
        if (startTime >= nextUpdate) {
            Director.updateGameObjects()
            Audio.updateAudio()

            nextUpdate = startTime + frameLifetime
        }
    }

    override fun dispose() {
        batch.dispose()
    }
}
