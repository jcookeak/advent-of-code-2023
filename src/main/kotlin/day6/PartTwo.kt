package day6

import util.parseLines
import kotlin.time.measureTimedValue

/**
 * As the race is about to start, you realize the piece of paper with race times and record distances you got earlier actually just has very bad kerning. There's really only one race - ignore the spaces between the numbers on each line.
 *
 * So, the example from before:
 *
 * Time:      7  15   30
 * Distance:  9  40  200
 * ...now instead means this:
 *
 * Time:      71530
 * Distance:  940200
 * Now, you have to figure out how many ways there are to win this single race. In this example, the race lasts for 71530 milliseconds and the record distance you need to beat is 940200 millimeters. You could hold the button anywhere from 14 to 71516 milliseconds and beat the record, a total of 71503 ways!
 *
 *
 */
fun partTwo(input: String): LongRange =
    parsePartTwo(input)
        .let { record ->
            measureTimedValue {
                TODO()
            }
                .also {
                    println("took ${it.duration}")
                }
                .value
        }

fun parsePartTwo(input: String): RaceRecord =
    input.parseLines {
        it.replace(Regex("\\s+"), "") // remove all padding
            .split(":").last()
            .trim()
    }
        .toList()
        .let { (time, distance, _) ->
            RaceRecord(time = time.toLong(), distance = distance.toLong())
        }
