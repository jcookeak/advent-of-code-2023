package test

import io.kotest.assertions.assertSoftly

inline fun <reified T> T.assert(block: T.() -> Unit): Unit =
    assertSoftly {
        block()
    }
