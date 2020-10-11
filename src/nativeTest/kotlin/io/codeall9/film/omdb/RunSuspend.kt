package io.codeall9.film.omdb

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun runSuspend(block: suspend (scope: CoroutineScope) -> Unit) = runBlocking { block(this) }