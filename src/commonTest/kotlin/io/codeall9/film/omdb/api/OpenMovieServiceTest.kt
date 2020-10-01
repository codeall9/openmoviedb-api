package io.codeall9.film.omdb.api

import io.codeall9.film.omdb.runSuspend
import io.codeall9.film.omdb.test.testMovie1
import io.codeall9.film.omdb.test.testMovie2
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.statement.*
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class OpenMovieServiceTest {

    @Test
    fun verifyGetDetailRequest() = runSuspend {
        val input = testMovie1

        val httpClient = buildOpenMovieClient(
            MockEngine,
            { addHandler{ respondOk() } },
            "API_KEY",
            OMDB_BASE_URL,
            { logger = Logger.DEFAULT; level = LogLevel.INFO }
        )
        val service = OpenMovieService(httpClient)

        val actual = service
            .getDetail(input.imdbId, input.title, input.type, input.year, "short", "json")
            .request

        assertEquals(HttpMethod.Get, actual.method)

        assertEquals(input.imdbId, actual.url.parameters[OmdbParameters.IMDB_ID])
        assertEquals(input.title, actual.url.parameters[OmdbParameters.TITLE])
        assertEquals(input.type, actual.url.parameters[OmdbParameters.RESULT_TYPE])
        assertEquals(input.year, actual.url.parameters[OmdbParameters.YEAR])
        assertEquals("short", actual.url.parameters[OmdbParameters.PLOT])
        assertEquals("json", actual.url.parameters[OmdbParameters.FORMAT])
        assertEquals("1", actual.url.parameters[OmdbParameters.VERSION])
    }

    @Test
    fun verifySearchFilmsRequest() = runSuspend {
        val input = testMovie2

        val httpClient = buildOpenMovieClient(
            MockEngine,
            { addHandler{ respondOk() } },
            "API_KEY",
            OMDB_BASE_URL,
            { logger = Logger.DEFAULT; level = LogLevel.INFO }
        )
        val service = OpenMovieService(httpClient)

        val actual = service
            .searchFilms(input.title, input.type, input.year, "json", 2)
            .request

        assertEquals(HttpMethod.Get, actual.method)

        assertEquals(input.title, actual.url.parameters[OmdbParameters.SEARCH])
        assertEquals(input.type, actual.url.parameters[OmdbParameters.RESULT_TYPE])
        assertEquals(input.year, actual.url.parameters[OmdbParameters.YEAR])
        assertEquals("2", actual.url.parameters[OmdbParameters.PAGE])
        assertEquals("json", actual.url.parameters[OmdbParameters.FORMAT])
        assertEquals("1", actual.url.parameters[OmdbParameters.VERSION])
    }

    @Test
    fun shouldRequireIdOrTitleNotNull() = runSuspend {
        val httpClient = buildOpenMovieClient(
            MockEngine,
            { addHandler{ respondOk() } },
            "API_KEY",
            OMDB_BASE_URL,
            { logger = Logger.DEFAULT; level = LogLevel.INFO }
        )
        val service = OpenMovieService(httpClient)

        assertFailsWith<IllegalArgumentException> {
            service.getDetail(null, null, null, null, null, null)
        }
    }

}