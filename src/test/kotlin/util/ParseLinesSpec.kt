package util

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import test.assert

class ParseLinesSpec : FunSpec({
    test("parse lines to ints") {
        """
        1
        2
        3
        11
        """.trimIndent()
            .parseLines { line ->
                line.toInt()
            }
            .assert {
                this.toList() shouldContainExactly setOf(1, 2, 3, 11)
            }
    }
})
