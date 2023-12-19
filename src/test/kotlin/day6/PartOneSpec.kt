package day6

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import test.assert

class PartOneSpec : FunSpec({
    context("parse") {
        test("provided example") {
            parsePartOne(
                """
                Time:      7  15   30
                Distance:  9  40  200
                """.trimIndent(),
            )
                .assert {
                    shouldHaveSize(3)

                    this[0].assert {
                        time shouldBe 7
                        distance shouldBe 9
                    }

                    this[1].assert {
                        time shouldBe 15
                        distance shouldBe 40
                    }

                    this[2].assert {
                        time shouldBe 30
                        distance shouldBe 200
                    }
                }
        }

        test("extra whitespace") {
            parsePartOne(
                """
                Time :      7    15     30
                Distance  :  9   40  200
                """.trimIndent(),
            )
                .assert {
                    shouldHaveSize(3)

                    this[0].assert {
                        time shouldBe 7
                        distance shouldBe 9
                    }

                    this[1].assert {
                        time shouldBe 15
                        distance shouldBe 40
                    }

                    this[2].assert {
                        time shouldBe 30
                        distance shouldBe 200
                    }
                }
        }
    }

    context("solution") {
        test("provided example") {
            partOne(
                """
                Time:      7  15   30
                Distance:  9  40  200
                """.trimIndent(),
            ) // 1159152
                .assert {
                    this.fold(1) { acc, results ->
                        acc * results.scores.size
                    } shouldBe 288
                }
        }

        test("prompt") {
            partOne(
                """
                Time:        58     81     96     76
                Distance:   434   1041   2219   1218
                """.trimIndent(),
            ) // 1159152
                .assert {
                    this.fold(1) { acc, results ->
                        acc * results.scores.size
                    } shouldBe 1159152
                }
        }
    }
})
