package io.codeall9.film.omdb

import kotlinx.coroutines.CoroutineScope

expect fun runSuspend(block: suspend (scope : CoroutineScope) -> Unit)