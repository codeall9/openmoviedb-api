package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.FilmType
import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.model.ErrorStatus
import io.codeall9.film.omdb.model.FilmInfo
import io.codeall9.film.omdb.model.SearchResult
import io.codeall9.film.omdb.runSuspend
import io.codeall9.film.omdb.test.MockOmdbClient
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchQueryTest {

    private val searchMovie = listOf(
        FilmInfo("tt0372784", "test1.jpg", "Batman Begins", "movie", "2005"),
        FilmInfo("tt2975590", "test2.jpg", "Batman v Superman: Dawn of Justice", "movie", "2016"),
        FilmInfo("tt4116284", "test3.jpg", "The Lego Batman Movie", "movie", "2017"),
        FilmInfo("tt2313197", "test4.jpg", "Batman: The Dark Knight Returns, Part 1", "movie", "2012")
    )
    private val movieResult = SearchResult(searchMovie, "10", "True")

    private val searchSeries = listOf(
        FilmInfo("tt0411008", "test1.jpg", "Lost", "series", "2004–2010"),
        FilmInfo("tt5232792", "test2.jpg", "Lost in Space", "series", "2018–")
    )
    private val seriesResult = SearchResult(searchSeries, "5", "True")

    private val searchEpisode = listOf(
        FilmInfo("tt1256035", "test1.jpg", "The Griffin Equivalency", "episode", "2008")
    )
    private val episodeResult = SearchResult(searchEpisode, "1", "True")

    private val starWars1 = listOf(
        FilmInfo("tt0120915", "test1.jpg", "Star Wars: Episode I - The Phantom Menace", "movie", "1999"),
        FilmInfo("tt0356070", "test2.jpg", "Star Wars: Knights of the Old Republic", "game", "2003"),
        FilmInfo("tt0458290", "test3.jpg", "Star Wars: The Clone Wars", "series", "2008–2020")
    )
    private val starWars2 = listOf(
        FilmInfo("tt0076759", "test1.jpg", "Star Wars: Episode IV - A New Hope", "movie", "1977"),
        FilmInfo("tt2488496", "test2.jpg", "Star Wars: Episode VII - The Force Awakens", "movie", "2015"),
        FilmInfo("tt3778644", "test3.jpg", "Solo: A Star Wars Story", "movie", "2018")
    )
    private val allResult = listOf(
        SearchResult(starWars1, "50", "True"),
        SearchResult(starWars2, "50", "True")
    )

    private val mockDb = MockOmdbClient.doOnSearch { query, type, _, page ->
        when {
            query == FilmType.MOVIE && type == FilmType.MOVIE -> movieResult
            query == FilmType.SERIES && type == FilmType.SERIES -> seriesResult
            query == FilmType.EPISODE && type == FilmType.EPISODE -> episodeResult
            query.isNotBlank() && type == null -> allResult[(page - 1) % 2]
            else -> throw OpenMovieException(ErrorStatus("False", "Movie not found"))
        }
    }

    @Test
    fun verifySearchMovie() = runSuspend {
//        println("getMovieResult")
        mockDb.getQuery(FilmType.MOVIE)
            .getMovieResult()
            .run { assertEquals(movieResult, this) }
    }

    @Test
    fun verifySearchSeries() = runSuspend {
//        println("getSeriesResult")
        mockDb.getQuery(FilmType.SERIES)
            .getSeriesResult()
            .run { assertEquals(seriesResult, this) }
    }

    @Test
    fun verifySearchEpisode() = runSuspend {
//        println("getEpisodeResult")
        mockDb.getQuery(FilmType.EPISODE)
            .getEpisodeResult()
            .run { assertEquals(episodeResult, this) }
    }

    @Test
    fun verifySearchAll() {
        val query = mockDb.getQuery("star wars")
        runSuspend {
//            println("getResult page 2")
            query.getResult(2)
                .run { assertEquals(starWars2, results) }
        }
        runSuspend {
//            println("getResult page 1")
            query.getResult(1)
                .run { assertEquals(starWars1, results) }
        }
    }
}