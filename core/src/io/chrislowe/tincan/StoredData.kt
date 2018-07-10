package io.chrislowe.tincan

abstract class StoredData {
    companion object {
        const val highScoreKey = "highScore"
        const val tutorialIconKey = "showTutorialIcon"
        const val musicVolumeKey = "musicVolume"
        const val sfxVolumeKey = "sfxVolume"
    }

    abstract fun getLeaderboardKey(): String

    abstract fun showTutorialIcon(): Boolean
    abstract fun currentHighScore(): Int
    abstract fun submitHighScore(newScore: Int)

    abstract fun getMusicVolume(): Int
    abstract fun setMusicVolume(newVolume: Int)

    abstract fun getSfxVolume(): Int
    abstract fun setSfxVolume(newVolume: Int)
}