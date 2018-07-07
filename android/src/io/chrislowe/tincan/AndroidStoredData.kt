package io.chrislowe.tincan

import android.content.SharedPreferences

class AndroidStoredData(private val preferences: SharedPreferences) : StoredData() {

    override fun showTutorialIcon(): Boolean {
        val showIconCount = preferences.getInt(tutorialIconKey, 2)

        return if (showIconCount == 0) false
        else {
            with (preferences.edit()) {
                putInt(tutorialIconKey, showIconCount - 1)
                apply()
            }
            true
        }
    }

    override fun currentHighScore() = preferences.getInt(highScoreKey, 0)

    override fun submitHighScore(newScore: Int) {
        with (preferences.edit()) {
            putInt(highScoreKey, newScore)
            apply()
        }
    }
}