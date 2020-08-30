package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.*
import io.codeall9.film.omdb.model.Episode
import io.codeall9.film.omdb.model.Movie
import io.codeall9.film.omdb.model.SearchResult
import io.codeall9.film.omdb.model.Series
import io.ktor.client.engine.*
import io.ktor.client.features.logging.*
import io.ktor.http.*

class OmdbClient internal constructor(private val apiService: OmdbApi, var defaultPlot: String? = null) : OpenMovieDatabase {

    override suspend fun getMovieById(id: String, plot: String?): Movie = apiService
            .getMovie(id, null, null, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun getMovieByTitle(title: String, year: String?, plot: String?): Movie = apiService
            .getMovie(null, title, year, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun getSeriesById(id: String, plot: String?): Series = apiService
            .getSeries(id, null, null, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun getSeriesByTitle(title: String, year: String?, plot: String?): Series = apiService
            .getSeries(null, title, year, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun getEpisodeById(id: String, plot: String?): Episode = apiService
            .getEpisode(id, null, null, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun getEpisodeByTitle(title: String, year: String?, plot: String?): Episode = apiService
            .getEpisode(null, title, year, plot ?: defaultPlot)
            .parseOmdbResponse()

    override suspend fun searchFilms(query: String, type: String?, year: String?, page: Int): SearchResult = apiService
            .searchFilms(query, type, year, page)
            .parseOmdbResponse()

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