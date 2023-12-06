package day1

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import test.assert

class PartOneSpec : FunSpec({
    test("provided example") {
        partOne(
            """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
            """.trimIndent(),
        )
            .toList()
            .assert {
                this shouldContainExactly listOf(12, 38, 15, 77)
                sum() shouldBe 142
            }
    }
})
