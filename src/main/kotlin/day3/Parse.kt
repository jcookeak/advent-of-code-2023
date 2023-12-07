package day3

private data class Acc(
    val start: Int = -1,
    val pointer: String = "",
    val schematic: Schematic,
)

fun parse(input: String) =
    input.lineSequence()
        .foldIndexed(Schematic()) { lineNumber, schematic, line ->
            ("$line.").foldIndexed(Acc(-1, "", schematic)) { index, acc, c ->
                when {
                    c.isDigit() -> {
                        Acc(
                            start = if (acc.start < 0) index else acc.start,
                            pointer = acc.pointer + c,
                            schematic = acc.schematic,
                        )
                    }

                    c == '.' -> {
                        val parts =
                            if (acc.start >= 0) {
                                acc.schematic.parts +
                                    PartNumber(
                                        value = acc.pointer.toInt(),
                                        line = lineNumber,
                                        index =
                                            PartNumber.Index(
                                                start = acc.start,
                                                end = index - 1,
                                            ),
                                    )
                            } else {
                                acc.schematic.parts
                            }

                        Acc(
                            schematic =
                                acc.schematic.copy(
                                    parts = parts,
                                ),
                        )
                    }

                    else -> {
                        val parts =
                            if (acc.start >= 0) {
                                acc.schematic.parts +
                                    PartNumber(
                                        value = acc.pointer.toInt(),
                                        line = lineNumber,
                                        index =
                                            PartNumber.Index(
                                                start = acc.start,
                                                end = index - 1,
                                            ),
                                    )
                            } else {
                                acc.schematic.parts
                            }

                        Acc(
                            schematic =
                                acc.schematic.copy(
                                    parts = parts,
                                    symbols =
                                        acc.schematic.symbols +
                                            SymbolCoordinate(
                                                symbol = c.toString(),
                                                x = index,
                                                y = lineNumber,
                                            ),
                                ),
                        )
                    }
                }
            }.schematic
        }
