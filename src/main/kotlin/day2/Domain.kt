package day2

data class Colors(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
)

data class Game(
    val id: Int,
    val sets: List<Colors>,
) {
    enum class Color {
        RED,
        GREEN,
        BLUE,
    }
}
