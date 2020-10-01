package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.model.*
import io.codeall9.film.omdb.test.*
import io.codeall9.film.omdb.test.JSON_EPISODE_1
import io.codeall9.film.omdb.test.JSON_MOVIE_1
import io.codeall9.film.omdb.test.testEpisode1
import io.codeall9.film.omdb.test.testMovie1
import kotlin.test.Test
import kotlin.test.assertEquals

class OmdbResponseTest {

    @Test
    fun verifyParseMovieJson() {
        val input = JSON_MOVIE_1
        val expect = testMovie1

        val json = createOmdbJsonFormat()
        val actual = input
            .let { json.parseToJsonElement(it) }
            .parseOmdbJson<Movie>()

        assertEquals(expect, actual)
    }

    @Test
    fun verifyParseSeriesJson() {
        val input = JSON_SERIES_1
        val expect = testSeries1

        val json = createOmdbJsonFormat()
        val actual = input
            .let { json.parseToJsonElement(it) }
            .parseOmdbJson<Series>()

        assertEquals(expect, actual)
    }

    @Test
    fun verifyParseEpisodeJson() {
        val input = JSON_EPISODE_1
        val expect = testEpisode1

        val json = createOmdbJsonFormat()
        val actual = input
            .let { json.parseToJsonElement(it) }
            .parseOmdbJson<Episode>()

        assertEquals(expect, actual)
    }

    @Test
    fun verifyParseSearchResultJson() {
        val input = JSON_SEARCH_1
        val expect = testSearch1

        val json = createOmdbJsonFormat()
        val actual = input
            .let { json.parseToJsonElement(it) }
            .parseOmdbJson<SearchResult>()

        assertEquals(expect, actual)
    }

    @Test
    fun verifyParseErrorStatusJson() {
        val input = JSON_NOT_FOUND
        val expect = testNotFoundError

        val json = createOmdbJsonFormat()
        val actual = input
            .let { json.parseToJsonElement(it) }
            .parseOmdbJson<ErrorStatus>()

        assertEquals(expect, actual)
    }
}