package day1

import util.parseLines

/**
 * Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters: one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
 *
 * Equipped with this new information, you now need to find the real first and last digit on each line. For example:
 *
 * two1nine
 * eightwothree
 * abcone2threexyz
 * xtwone3four
 * 4nineeightseven2
 * zoneight234
 * 7pqrstsixteen
 * In this example, the calibration values are 29, 83, 13, 24, 42, 14, and 76. Adding these together produces 281.
 *
 * What is the sum of all of the calibration values?
 */
fun partTwo(input: String): Sequence<Int> =
    input.parseLines(::parse)
        .map { "${it.first()}${it.last()}".toInt() }

fun parse(line: String): List<Int> = line.fold(ParseAcc()) { acc, c ->
        (acc.pointer + c).numberOrNull()?.let {
            ParseAcc(
                acc.numbers + it,
                "$c",
            )
        } ?: acc.copy(
            pointer = acc.pointer + c,
        )
    }
        .numbers

private data class ParseAcc(
    val numbers: List<Int> = emptyList(),
    val pointer: String = "",
)

private fun String.numberOrNull(): Int? =
    numbers.firstNotNullOfOrNull { (key, value) ->
        if (
            (this.toIntOrNull()?.let { "$it".last() } ?: this).toString()
                .contains(key)
        ) {
            value
        } else {
            null
        }
    }

private val numbers =
    mapOf(
        "one" to 1,
        "1" to 1,
        "two" to 2,
        "2" to 2,
        "three" to 3,
        "3" to 3,
        "four" to 4,
        "4" to 4,
        "five" to 5,
        "5" to 5,
        "six" to 6,
        "6" to 6,
        "seven" to 7,
        "7" to 7,
        "eight" to 8,
        "8" to 8,
        "nine" to 9,
        "9" to 9,
        "zero" to 0,
        "0" to 0,
    )
