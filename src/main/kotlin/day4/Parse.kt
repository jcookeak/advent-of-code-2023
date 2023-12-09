package day4

import util.splitOn

fun parse(line: String): Card =
    line
        .replace(Regex("\\s+"), " ") // swap all padding to single space
        .splitOn(":").let { (card, tail) ->
            tail
                .trim().splitOn("|")
                .let { (a, b) ->
                    Card(
                        id = card.splitOn(" ").second.toInt(),
                        winning = a.trim().split(" ").map { it.toInt() }.toSet(),
                        yours = b.trim().split(" ").map { it.toInt() }.toSet(),
                    )
                }
        }
