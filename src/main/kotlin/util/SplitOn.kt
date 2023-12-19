package util

fun String.splitOn(value: String): Pair<String, String> =
    this.split(value)
        .let { split ->
            split.takeIf { it.size == 2 }
                ?.let { it[0] to it[1] }
                ?: error("expected exactly 2 lists not ${split.size} '$this'")
        }
