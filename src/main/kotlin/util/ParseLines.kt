package util

fun <T> String.parseLines(block: (String) -> T): Sequence<T> = this.lineSequence().map(block)
