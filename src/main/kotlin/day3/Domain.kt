package day3

data class SymbolCoordinate(
    val symbol: String,
    val x: Int,
    val y: Int,
)

data class PartNumber(
    val value: Int,
    val line: Int,
    val index: Index,
) {
    data class Index(
        val start: Int,
        val end: Int,
    ) {
        init {
            require(start <= end) {
                "cannot have index with start after end"
            }
        }
    }
}

data class Schematic(
    val parts: List<PartNumber> = emptyList(),
    val symbols: List<SymbolCoordinate> = emptyList(),
)
