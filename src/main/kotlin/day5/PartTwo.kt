package day5

import kotlinx.coroutines.coroutineScope

/**
 * Everyone will starve if you only plant such a small number of seeds. Re-reading the almanac, it looks like the seeds: line actually describes ranges of seed numbers.
 *
 * The values on the initial seeds: line come in pairs. Within each pair, the first value is the start of the range and the second value is the length of the range. So, in the first line of the example above:
 *
 * seeds: 79 14 55 13
 * This line describes two ranges of seed numbers to be planted in the garden. The first range starts with seed number 79 and contains 14 values: 79, 80, ..., 91, 92. The second range starts with seed number 55 and contains 13 values: 55, 56, ..., 66, 67.
 *
 * Now, rather than considering four seed numbers, you need to consider a total of 27 seed numbers.
 *
 * In the above example, the lowest location number can be obtained from seed number 82, which corresponds to soil 84, fertilizer 84, water 84, light 77, temperature 45, humidity 46, and location 46. So, the lowest location number is 46.
 *
 * Consider all of the initial seed numbers listed in the ranges on the first line of the almanac. What is the lowest location number that corresponds to any of the initial seed numbers?
 */
suspend fun partTwo(input: String): List<LongRange> =
    coroutineScope {
        parse(input)
            .let { almanac ->
                almanac.seeds.chunked(2)
                    .map { (start, length) -> (start until (start + length)) }
                    .let { seedRanges ->
                        almanac.ranges.fold(seedRanges) { mapped, level ->
                            mapped.map { value ->
                                async {
                                    level.applyMapping(value)
                                }
                            }
                                .awaitAll()
                                .flatten()
                        }
                    }
            }
    }

data class Split(
    val outsideStart: LongRange? = null,
    val overlap: LongRange? = null,
    val outsideEnd: LongRange? = null,
)

infix fun LongRange.minCommon(other: LongRange): Long? =
    kotlin.math.max(first, other.first)
        .takeIf { it in this }
        ?.takeIf { it in other }

infix fun LongRange.maxCommon(other: LongRange): Long? =
    kotlin.math.min(last, other.last)
        .takeIf { it in this }
        ?.takeIf { it in other }

infix fun LongRange.overlap(other: LongRange): Split {
    val maxCommon = this maxCommon other
    val minCommon = this minCommon other

    return Split(
        (minCommon?.let { first until minCommon } ?: this.takeIf { last <= other.first })
            ?.takeIf { it.first <= it.last },
        (
            minCommon?.let {
                maxCommon?.let {
                    minCommon..maxCommon
                }
            }
        )?.takeIf { it.first <= it.last },
        (maxCommon?.let { (maxCommon + 1)..endInclusive } ?: this.takeIf { first >= other.last })
            ?.takeIf { it.first <= it.last },
    )
}

private fun List<RangeDelta>.applyMapping(range: LongRange): List<LongRange> =
    this
        .fold<RangeDelta, Pair<List<LongRange>, LongRange?>>(emptyList<LongRange>() to range) { (acc, remaining), rangeDelta ->
            (remaining?.overlap(rangeDelta.range))?.let {
                acc +
                    listOfNotNull(
                        it.outsideStart,
                        it.overlap?.let { it.first + rangeDelta.delta..it.last + rangeDelta.delta },
                    ) to it.outsideEnd
            } ?: return acc
        }
        .let { (mapped, remaining) -> mapped + listOfNotNull(remaining) }
