package day4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import test.assert

class ParseSpec : FunSpec({
    test("card with matching values") {
        parse("Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53")
            .assert {
                id shouldBe 1
                winning shouldContainExactly
                    setOf(
                        41, 48, 83, 86, 17,
                    )
                yours shouldContainExactly
                    setOf(
                        83, 86, 6, 31, 17, 9, 48, 53,
                    )
            }
    }

    test("handle extra padding") {
        parse("Card   1: 41 48 83 86   17 | 83 86   6 31 17   9 48   53  ")
            .assert {
                id shouldBe 1
                winning shouldContainExactly
                    setOf(
                        41, 48, 83, 86, 17,
                    )
                yours shouldContainExactly
                    setOf(
                        83, 86, 6, 31, 17, 9, 48, 53,
                    )
            }
    }
})
