package io.chrislowe.tincan

import android.content.SharedPreferences

class AndroidStoredData(private val preferences: SharedPreferences) : StoredData() {

    override fun currentHighScore() = preferences.getInt(highScoreKey, 0)

    override fun submitHighScore(newScore: Int) {
        with (preferences.edit()) {
            putInt(highScoreKey, newScore)
            apply()
        }
    }
}