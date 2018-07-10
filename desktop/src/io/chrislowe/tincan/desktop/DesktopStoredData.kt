package io.chrislowe.tincan.desktop

import io.chrislowe.tincan.StoredData

class DesktopStoredData : StoredData() {
    // TODO (if I ever release a desktop version)

    override fun getLeaderboardKey(): String = "notSupportedOnDesktop"

    override fun showTutorialIcon(): Boolean = true
    override fun currentHighScore() = 0
    override fun submitHighScore(newScore: Int) {}

    override fun getMusicVolume(): Int = 0
    override fun setMusicVolume(newVolume: Int) {}

    override fun getSfxVolume(): Int = 0
    override fun setSfxVolume(newVolume: Int) {}
}