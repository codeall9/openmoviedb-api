package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.OmdbApi
import io.codeall9.film.omdb.api.OpenMovieService
import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.runSuspend
import io.codeall9.film.omdb.test.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.headersOf
import io.ktor.http.withCharset
import io.ktor.utils.io.charsets.Charsets
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

internal class OmdbClientTest {

    private val invalidEpisode = testEpisode1.copy(imdbId = "INVALID", title = "INVALID")
    private val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
        val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
        val params = req.url.parameters
        val id = params["i"]
        val title = params["t"]
        when {
            id == testSeries1.imdbId || title == testSeries1.title -> respond(content = JSON_SERIES_1, headers = headers)
            id == testEpisode1.imdbId || title == testEpisode1.title -> respond(content = JSON_EPISODE_1, headers = headers)
            id == testMovie1.imdbId || title == testMovie1.title -> respond(content = JSON_MOVIE_1, headers = headers)
            id == invalidEpisode.imdbId || title == invalidEpisode.title -> respond(content = JSON_NOT_FOUND, headers = headers)
            params.contains("s") -> respond(content = JSON_SEARCH_1, headers = headers)
            params.contains("i") || params.contains("t") -> respond(content = JSON_MOVIE_2, headers = headers)
            else -> respond(content = JSON_NOT_FOUND, headers = headers)
        }
    }

    private val mockApi: OmdbApi = OpenMovieService(HttpClient(MockEngine) {
        engine { addHandler(mockHandler) }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
    })

    private val database = OmdbClient(mockApi)

    @Test
    fun verifyMovieById() = runSuspend {
        val result = database.getMovieById(testMovie1.imdbId)
        assertEquals(testMovie1, result)
    }

    @Test
    fun verifyMovieByTitle() = runSuspend {
        val result = database.getMovieByTitle(testMovie1.title)
        assertEquals(testMovie1, result)
    }

    @Test
    fun verifySeriesById() = runSuspend {
        val result = database.getSeriesById(testSeries1.imdbId)
        assertEquals(testSeries1, result)
    }

    @Test
    fun verifySeriesByTitle() = runSuspend {
        val result = database.getSeriesByTitle(testSeries1.title)
        assertEquals(testSeries1, result)
    }

    @Test
    fun verifyEpisodeById() = runSuspend {
        val result = database.getEpisodeById(testEpisode1.imdbId)
        assertEquals(testEpisode1, result)
    }

    @Test
    fun verifyEpisodeByTitle() = runSuspend {
        val result = database.getEpisodeByTitle(testEpisode1.title)
        assertEquals(testEpisode1, result)
    }

    @Test
    fun verifySearchFilms() = runSuspend {
        val result = database.searchFilms("any")
        assertEquals(testSearch1, result)
    }

    @Test
    fun shouldThrowException() = runSuspend {
        runCatching { database.getEpisodeByTitle(invalidEpisode.title) }
            .onFailure { assertTrue(it is OpenMovieException) }
            .onSuccess { fail() }
    }

}