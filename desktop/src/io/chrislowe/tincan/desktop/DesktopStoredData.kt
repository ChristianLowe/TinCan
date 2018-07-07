package io.chrislowe.tincan.desktop

import io.chrislowe.tincan.StoredData

class DesktopStoredData : StoredData() {
    // TODO (if I ever release a desktop version)

    override fun showTutorialIcon(): Boolean = true

    override fun currentHighScore() = 0

    override fun submitHighScore(newScore: Int) {}
}