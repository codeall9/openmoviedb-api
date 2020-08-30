package io.codeall9.film.omdb.api

import io.codeall9.film.omdb.runSuspend
import io.codeall9.film.omdb.test.testMovie1
import io.codeall9.film.omdb.test.testMovie2
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.http.HttpMethod
import io.ktor.http.Url
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class OpenMovieServiceTest {

    private val testKey = "key987"
    private val testHost = "api.test.come"

    private val mockClient = buildOpenMovieClient(
        MockEngine,
        { addHandler{ respondOk() } },
        testKey,
        testHost,
        { logger = Logger.DEFAULT; level = LogLevel.INFO }
    )

    private val service = OpenMovieService(mockClient)

    @Test
    fun verifyGetDetailRequest() = runSuspend {
        val response = testMovie1.run {
            service.getDetail(imdbId, title, type, year, "short", "json")
        }
        val request = response.call.request
        val parameters = request.url.parameters
        verifyBaseRequestUrl(request.url)
        assertEquals(HttpMethod.Get, request.method)
        testMovie1.run {
            assertEquals(imdbId, parameters[OmdbParameters.IMDB_ID])
            assertEquals(title, parameters[OmdbParameters.TITLE])
            assertEquals(type, parameters[OmdbParameters.RESULT_TYPE])
            assertEquals(year, parameters[OmdbParameters.YEAR])
            assertEquals("short", parameters[OmdbParameters.PLOT])
            assertEquals("json", parameters[OmdbParameters.FORMAT])
            assertEquals("1", parameters[OmdbParameters.VERSION])
        }
    }

    @Test
    fun verifySearchFilmsRequest() = runSuspend {
        val response = testMovie2.run {
            service.searchFilms(title, type, year, "json", 2)
        }
        val request = response.call.request
        val parameters = request.url.parameters
        verifyBaseRequestUrl(request.url)
        assertEquals(HttpMethod.Get, request.method)
        testMovie2.run {
            assertEquals(title, parameters[OmdbParameters.SEARCH])
            assertEquals(type, parameters[OmdbParameters.RESULT_TYPE])
            assertEquals(year, parameters[OmdbParameters.YEAR])
            assertEquals("2", parameters[OmdbParameters.PAGE])
            assertEquals("json", parameters[OmdbParameters.FORMAT])
            assertEquals("1", parameters[OmdbParameters.VERSION])
        }
    }

    @Test
    fun shouldRequireIdOrTitleNotNull() = runSuspend {
        assertFailsWith<IllegalArgumentException> {
            service.getDetail(null, null, null, null, null, null)
        }
    }

    private fun verifyBaseRequestUrl(requestUrl: Url) {
        assertEquals(testHost, requestUrl.host)
        assertEquals(testKey, requestUrl.parameters["apiKey"])
    }

}