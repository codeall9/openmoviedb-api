package io.codeall9.film.omdb.exception

import io.codeall9.film.omdb.model.ErrorStatus

class OpenMovieException(
    val body: ErrorStatus
) : IllegalStateException("Bad response: $body")