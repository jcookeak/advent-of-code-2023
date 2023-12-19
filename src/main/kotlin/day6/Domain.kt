package day6

data class RaceScore(
    val timeHeld: Long,
    val distance: Long,
)

data class RaceRecord(
    val time: Long,
    val distance: Long,
)

data class RaceResults(
    val time: Long,
    val scores: List<RaceScore>,
)
