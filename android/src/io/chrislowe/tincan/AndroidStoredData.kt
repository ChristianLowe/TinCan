package io.chrislowe.tincan

import android.content.SharedPreferences

class AndroidStoredData(private val preferences: SharedPreferences) : StoredData() {

    override fun showTutorialIcon(): Boolean {
        val showIconCount = preferences.getInt(tutorialIconKey, 2)

        return if (showIconCount == 0) false
        else {
            setInt(tutorialIconKey, showIconCount - 1)
            true
        }
    }

    override fun getLeaderboardKey(): String = BuildConfig.leaderboardKey

    override fun currentHighScore() = preferences.getInt(highScoreKey, 0)
    override fun submitHighScore(newScore: Int) = setInt(highScoreKey, newScore)

    override fun getMusicVolume(): Int = preferences.getInt(musicVolumeKey, 5)
    override fun setMusicVolume(newVolume: Int) = setInt(musicVolumeKey, newVolume)

    override fun getSfxVolume(): Int = preferences.getInt(musicVolumeKey, 5)
    override fun setSfxVolume(newVolume: Int) = setInt(sfxVolumeKey, newVolume)

    private fun setInt(keyName: String, value: Int) = with(preferences.edit()) {
        putInt(keyName, value)
        apply()
    }
}