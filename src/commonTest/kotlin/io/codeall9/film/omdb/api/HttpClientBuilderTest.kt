package io.codeall9.film.omdb.api

import io.codeall9.film.omdb.runSuspend
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class HttpClientBuilderTest {

    @Test
    fun verifyDefaultRequest() = runSuspend {
        val apiHost = OMDB_BASE_URL
        val apiKey = "OMDB_API_KEY"

        val mockClient = HttpClient(MockEngine) {
            engine {
                addHandler { respondOk() }
            }
            defaultOMDbRequest(apiHost, apiKey)
            Logging {
                level = LogLevel.HEADERS
                logger = Logger.DEFAULT
            }
        }

        val actual = mockClient.get<HttpResponse>().request

        assertEquals(apiHost, actual.url.host)
        assertEquals(apiKey, actual.url.parameters["apiKey"])
        assertEquals(URLProtocol.HTTP, actual.url.protocol)
        assertTrue { actual.headers.contains(HttpHeaders.Accept, ContentType.Application.Json.toString()) }
    }
}