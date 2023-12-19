package day6

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import test.assert

class PartTwoSpec : FunSpec({
    context("parse") {
        test("provided example") {
            parsePartTwo(
                """
                Time:      7  15   30
                Distance:  9  40  200
                """.trimIndent(),
            )
                .assert {
                    time shouldBe 71530
                    distance shouldBe 940200
                }
        }
    }

    context("solution") {
        test("provided example") {
            partTwo(
                """
                Time:      7  15   30
                Distance:  9  40  200
                """.trimIndent(),
            )
                .assert {
                    this.last + 1 - this.first shouldBe 71503L
                }
        }

        test("prompt") {
            partTwo(
                """
                Time:        58     81     96     76
                Distance:   434   1041   2219   1218
                """.trimIndent(),
            )
                .assert {
                    this.last + 1 - this.first shouldBe 41513103L
                }
        }
    }
})
