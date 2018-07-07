package io.chrislowe.tincan

abstract class StoredData {
    companion object {
        const val highScoreKey = "highScore"
        const val tutorialIconKey = "showTutorialIcon"
    }

    abstract fun showTutorialIcon(): Boolean
    abstract fun currentHighScore(): Int
    abstract fun submitHighScore(newScore: Int)
}