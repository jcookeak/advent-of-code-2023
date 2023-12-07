package day2

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import test.assert

class ParseSpec : FunSpec({
    test("parse game line") {
        parse("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
            .assert {
                id shouldBe 1
                sets.assert {
                    shouldHaveSize(3)

                    this[0].assert {
                        red shouldBe 4
                        green shouldBe 0
                        blue shouldBe 3
                    }

                    this[1].assert {
                        red shouldBe 1
                        green shouldBe 2
                        blue shouldBe 6
                    }

                    this[2].assert {
                        red shouldBe 0
                        green shouldBe 2
                        blue shouldBe 0
                    }
                }
            }
    }
})
