package day5

import util.parseLines
import util.splitOn

data class Almanac(
    val seeds: List<Long> = emptyList(),
    val seedToSoil: List<RangeDelta> = emptyList(),
    val soilToFertilizer: List<RangeDelta> = emptyList(),
    val fertilizerToWater: List<RangeDelta> = emptyList(),
    val waterToLight: List<RangeDelta> = emptyList(),
    val lightToTemperature: List<RangeDelta> = emptyList(),
    val temperatureToHumidity: List<RangeDelta> = emptyList(),
    val humidityToLocation: List<RangeDelta> = emptyList(),
) {
    val ranges by lazy {
        listOf(
            seedToSoil,
            soilToFertilizer,
            fertilizerToWater,
            waterToLight,
            lightToTemperature,
            temperatureToHumidity,
            humidityToLocation,
        )
    }
}

data class SeedMap(
    val destination: Long,
    val source: Long,
    val length: Long,
)

fun parse(input: String) =
    input
        .split("^\\s*$".toRegex(RegexOption.MULTILINE)) // split on blank lines
        .filter { it.isNotBlank() }
        .map {
            it.splitOn(":")
                .let { (key, value) ->
                    key.replace("\\r\\n|\\r|\\n".toRegex(), "") to value.trim()
                }
        }
        .fold(Almanac()) { acc, (key, value) ->
            when {
                key.startsWith("seeds") -> acc.copy(seeds = value.trim().split(" ").map(String::toLong))
                key.startsWith("seed-to-soil") -> acc.copy(seedToSoil = value.toSeedMap().toRangeDelta())
                key.startsWith("soil-to-fertilizer") -> acc.copy(soilToFertilizer = value.toSeedMap().toRangeDelta())
                key.startsWith("fertilizer-to-water") ->
                    acc.copy(
                        fertilizerToWater = value.toSeedMap().toRangeDelta(),
                    )

                key.startsWith("water-to-light") -> acc.copy(waterToLight = value.toSeedMap().toRangeDelta())
                key.startsWith("light-to-temperature") ->
                    acc.copy(
                        lightToTemperature = value.toSeedMap().toRangeDelta(),
                    )

                key.startsWith("temperature-to-humidity") ->
                    acc.copy(
                        temperatureToHumidity = value.toSeedMap().toRangeDelta(),
                    )

                key.startsWith("humidity-to-location") ->
                    acc.copy(
                        humidityToLocation = value.toSeedMap().toRangeDelta(),
                    )

                else -> error("unknown key: $key")
            }
        }

private fun String.toSeedMap() =
    this.parseLines {
        it.split(" ")
            .map(String::toLong)
            .let { (destination, source, length) ->
                SeedMap(destination = destination, source = source, length = length)
            }
    }
        .toList()

/**
 * Represents a start and end (inclusive) + the required shift amount to the destination
 */
data class RangeDelta(
    val range: LongRange,
    val delta: Long,
) : ClosedRange<Long> by range

private fun List<SeedMap>.toRangeDelta(): List<RangeDelta> =
    this.map { seed ->
        RangeDelta(seed.source until (seed.source + seed.length), seed.destination - seed.source)
    }
        .sortedBy { it.start }
