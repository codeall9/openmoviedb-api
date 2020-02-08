package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.OMDB_BASE_URL
import io.codeall9.film.omdb.api.OmdbApi
import io.codeall9.film.omdb.api.OpenMovieService
import io.codeall9.film.omdb.api.buildOpenMovieClient
import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.model.*
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.URLProtocol
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.json.Json

class OmdbClient(private val apiService: OmdbApi, var defaultPlot: String? = null) : OpenMovieDatabase {

    override suspend fun getMovieById(id: String, year: String?, plot: String?): Movie = apiService
        .getDetail(id, null, TYPE_MOVIE, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Movie.serializer())

    override suspend fun getMovieByTitle(title: String, year: String?, plot: String?): Movie = apiService
        .getDetail(null, title, TYPE_MOVIE, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Movie.serializer())

    override suspend fun getSeriesById(id: String, year: String?, plot: String?): Series = apiService
        .getDetail(id, null, TYPE_SERIES, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Series.serializer())

    override suspend fun getSeriesByTitle(title: String, year: String?, plot: String?): Series = apiService
        .getDetail(null, title, TYPE_SERIES, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Series.serializer())

    override suspend fun getEpisodeById(id: String, year: String?, plot: String?): Episode = apiService
        .getDetail(id, null, TYPE_EPISODE, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Episode.serializer())

    override suspend fun getEpisodeByTitle(title: String, year: String?, plot: String?): Episode = apiService
        .getDetail(null, title, TYPE_EPISODE, year, plot ?: defaultPlot, FORMAT_JSON)
        .parseResponse(Episode.serializer())

    override suspend fun searchFilms(query: String, type: String?, year: String?, page: Int): SearchResult = apiService
        .searchFilms(query, type, year, FORMAT_JSON, page)
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

        const val TYPE_MOVIE = "movie"
        const val TYPE_SERIES = "series"
        const val TYPE_EPISODE = "episode"

        const val API_HOST = OMDB_BASE_URL

        const val PLOT_SHORT = "short"
        const val PLOT_FULL = "full"

        const val FORMAT_JSON = "json"

        private val simpleLogger: Logging.Config.() -> Unit = {
            logger = Logger.SIMPLE
            level = LogLevel.INFO
        }

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