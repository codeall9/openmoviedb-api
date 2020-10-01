package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.runSuspend
import io.codeall9.film.omdb.test.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.charsets.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

internal class OmdbClientTest {

    @Test
    fun verifyMovieById() = runSuspend {
        val input = testMovie1.imdbId
        val expect = testMovie1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["i"] == input) JSON_MOVIE_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val actual = database.getMovieById(input)

        assertEquals(expect, actual)
    }

    @Test
    fun verifyMovieByTitle() = runSuspend {
        val input = testMovie2.title
        val expect = testMovie2

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["t"] == input) JSON_MOVIE_2 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val actual = database.getMovieByTitle(input)

        assertEquals(expect, actual)
    }

    @Test
    fun verifySeriesById() = runSuspend {
        val input = testSeries1.imdbId
        val expect = testSeries1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["i"] == input) JSON_SERIES_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val result = database.getSeriesById(input)

        assertEquals(expect, result)
    }

    @Test
    fun verifySeriesByTitle() = runSuspend {
        val input = testSeries1.title
        val expect = testSeries1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["t"] == input) JSON_SERIES_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val result = database.getSeriesByTitle(input)
        assertEquals(expect, result)
    }

    @Test
    fun verifyEpisodeById() = runSuspend {
        val input = testEpisode1.imdbId
        val expect = testEpisode1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["i"] == input) JSON_EPISODE_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val result = database.getEpisodeById(input)
        assertEquals(expect, result)
    }

    @Test
    fun verifyEpisodeByTitle() = runSuspend {
        val input = testEpisode1.title
        val expect = testEpisode1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params["t"] == input) JSON_EPISODE_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val result = database.getEpisodeByTitle(input)
        assertEquals(expect, result)
    }

    @Test
    fun verifySearchFilms() = runSuspend {
        val expect = testSearch1

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { req ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            val params = req.url.parameters
            val responseContent = if (params.contains("s")) JSON_SEARCH_1 else JSON_NOT_FOUND
            respond(content = responseContent, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        val result = database.searchFilms("any")

        assertEquals(expect, result)
    }

    @Test
    fun shouldThrowException() = runSuspend {
        val input = "INVALID"

        val mockHandler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData = { _ ->
            val headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.withCharset(Charsets.UTF_8).toString())
            respond(content = JSON_NOT_FOUND, headers = headers)
        }
        val database = OmdbClient(
            engineFactory =  MockEngine,
            engineConfig = { addHandler(mockHandler) },
            apiKey = "API_KEY"
        )

        runCatching { database.getEpisodeByTitle(input) }
            .onFailure { assertTrue(it is OpenMovieException) }
            .onSuccess { fail() }
    }

}