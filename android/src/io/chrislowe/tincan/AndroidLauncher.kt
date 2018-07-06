package io.chrislowe.tincan

import android.content.Context
import android.os.Bundle

import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration

class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = AndroidApplicationConfiguration()
        config.useAccelerometer = false
        config.useCompass = false

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val androidStoredData = AndroidStoredData(preferences)
        initialize(TinCanGame(androidStoredData), config)
    }
}
