package io.chrislowe.tincan

abstract class StoredData {
    companion object {
        const val highScoreKey = "highScore"
    }

    abstract fun currentHighScore(): Int
    abstract fun submitHighScore(newScore: Int)
}