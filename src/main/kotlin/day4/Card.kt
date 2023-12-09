package day4

data class Card(
    val id: Int,
    val winning: Set<Int>,
    val yours: Set<Int>,
)
