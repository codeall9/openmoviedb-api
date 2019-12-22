package io.codeall9.film.omdb.api

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.features.cache.HttpCache
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol

internal const val OMDB_BASE_URL = "www.omdbapi.com"

internal fun HttpClientConfig<*>.defaultOMDbRequest(
    apiHost: String,
    apiKey: String,
    apiProtocol: URLProtocol = URLProtocol.HTTP
) = defaultRequest {
    url {
        protocol = apiProtocol
        host = apiHost
        parameter("apiKey", apiKey)
    }
    accept(ContentType.Application.Json)
}

internal fun <E : HttpClientEngineConfig> buildOpenMovieClient(
    engineFactory: HttpClientEngineFactory<E>,
    engineConfig: E.() -> Unit = {},
    apiKey: String,
    apiHost: String = OMDB_BASE_URL,
    initLogger: Logging.Config.() -> Unit = {},
    apiProtocol: URLProtocol = URLProtocol.HTTP
): HttpClient = HttpClient(engineFactory) {
    engine(engineConfig)
    defaultOMDbRequest(apiHost, apiKey, apiProtocol)
    Logging(initLogger)
    install(HttpCache)
}

internal fun buildOpenMovieClient(
    apiKey: String,
    apiHost: String = OMDB_BASE_URL,
    initLogger: Logging.Config.() -> Unit = {},
    apiProtocol: URLProtocol = URLProtocol.HTTP
): HttpClient = HttpClient {
    defaultOMDbRequest(apiHost, apiKey, apiProtocol)
    Logging(initLogger)
    install(HttpCache)
}