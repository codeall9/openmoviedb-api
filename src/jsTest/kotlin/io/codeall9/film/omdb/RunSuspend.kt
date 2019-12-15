package io.codeall9.film.omdb

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun runSuspend(block: suspend (scope: CoroutineScope) -> Unit): dynamic
        = GlobalScope.promise { block(this) }