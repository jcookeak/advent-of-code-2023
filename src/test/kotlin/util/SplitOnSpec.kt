package util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import test.assert

class SplitOnSpec : FunSpec({
    test("split input into pairs") {
        "a:b".splitOn(":").assert {
            first shouldBe "a"
            second shouldBe "b"
        }
    }

    context("failure") {
        test("delimiter not present") {
            shouldThrow<IllegalStateException> {
                "a b".splitOn(":")
            }
                .assert {
                    message shouldBe "expected exactly 2 lists not 1"
                }
        }

        test("delimiter present multiple times") {
            shouldThrow<IllegalStateException> {
                "a:b:c".splitOn(":")
            }
                .assert {
                    message shouldBe "expected exactly 2 lists not 3"
                }
        }
    }
})
