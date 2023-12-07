package day3

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import test.assert

class ParseSpec : FunSpec({
    test("provided example") {
        parse(
            """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
            """.trimIndent(),
        )
            .assert {
                parts.assert {
                    shouldHaveSize(10)
                }

                symbols.assert {
                    shouldHaveSize(6)
                }
            }
    }
})
