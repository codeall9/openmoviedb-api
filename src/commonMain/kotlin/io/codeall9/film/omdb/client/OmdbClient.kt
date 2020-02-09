package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.*
import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.model.*
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.features.logging.Logging
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.URLProtocol
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json

class OmdbClient(private val apiService: OmdbApi, var defaultPlot: String? = null) : OpenMovieDatabase {

    override suspend fun getMovieById(id: String, plot: String?): Movie = apiService
        .getMovie(id, null, null, plot ?: defaultPlot)
        .parseResponse(Movie.serializer())

    override suspend fun getMovieByTitle(title: String, year: String?, plot: String?): Movie = apiService
        .getMovie(null, title, year, plot ?: defaultPlot)
        .parseResponse(Movie.serializer())

    override suspend fun getSeriesById(id: String, plot: String?): Series = apiService
        .getSeries(id, null, null, plot ?: defaultPlot)
        .parseResponse(Series.serializer())

    override suspend fun getSeriesByTitle(title: String, year: String?, plot: String?): Series = apiService
        .getSeries(null, title, year, plot ?: defaultPlot)
        .parseResponse(Series.serializer())

    override suspend fun getEpisodeById(id: String, plot: String?): Episode = apiService
        .getEpisode(id, null, null, plot ?: defaultPlot)
        .parseResponse(Episode.serializer())

    override suspend fun getEpisodeByTitle(title: String, year: String?, plot: String?): Episode = apiService
        .getEpisode(null, title, year, plot ?: defaultPlot)
        .parseResponse(Episode.serializer())

    override suspend fun searchFilms(query: String, type: String?, year: String?, page: Int): SearchResult = apiService
        .searchFilms(query, type, year, page)
        .parseResponse(SearchResult.serializer())

    private suspend inline fun <T> HttpResponse.parseResponse(deserializer: DeserializationStrategy<T>): T {
        return Json.nonstrict.run {
            parseJson(readText())
                .also { element ->
                    element.jsonObject["Response"]
                        ?.takeUnless { it.primitive.content == "False" }
                        ?: throw OpenMovieException(fromJson(ErrorStatus.serializer(), element))
                }
                .let { fromJson(deserializer, it) }
        }
    }

    companion object {

        const val VERSION = 1
        const val API_HOST = OMDB_BASE_URL

        operator fun invoke(
            apiKey: String,
            plot: String? = null,
            logConfig: Logging.Config.() -> Unit = simpleLogger
        ): OmdbClient {
            val httpClient = buildOpenMovieClient(apiKey = apiKey, initLogger = logConfig)
            return OmdbClient(OpenMovieService(httpClient), plot)
        }

        operator fun <E : HttpClientEngineConfig> invoke(
            engineFactory: HttpClientEngineFactory<E>,
            engineConfig: E.() -> Unit = {},
            apiKey: String,
            plot: String? = null,
            apiHost: String = API_HOST,
            apiProtocol: URLProtocol = URLProtocol.HTTP,
            initLogger: Logging.Config.() -> Unit = simpleLogger
        ): OmdbClient {
            val httpClient = buildOpenMovieClient(
                engineFactory,
                engineConfig,
                apiKey,
                apiHost,
                initLogger,
                apiProtocol
            )
            return OmdbClient(OpenMovieService(httpClient), plot)
        }
    }
}