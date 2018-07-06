package io.chrislowe.tincan.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import io.chrislowe.tincan.TinCanGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        config.title = "Tin Can"
        config.width = TinCanGame.gameWidth.toInt()
        config.height = TinCanGame.gameHeight.toInt()

        LwjglApplication(TinCanGame(DesktopStoredData()), config)
    }
}
