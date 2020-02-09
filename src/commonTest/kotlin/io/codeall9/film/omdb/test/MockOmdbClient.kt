package io.codeall9.film.omdb.test

import io.codeall9.film.omdb.client.OpenMovieDatabase
import io.codeall9.film.omdb.model.Episode
import io.codeall9.film.omdb.model.Movie
import io.codeall9.film.omdb.model.SearchResult
import io.codeall9.film.omdb.model.Series

typealias MockFilmHandler<T> = suspend (key: String, year: String?, plot: String?) -> T
typealias MockSearchHandler = suspend (query: String, type: String?, year: String?, page: Int) -> SearchResult

class MockOmdbClient(
    private val onGetMovie: MockFilmHandler<Movie>? = null,
    private val onGetSeries: MockFilmHandler<Series>? = null,
    private val onGetEpisode: MockFilmHandler<Episode>? = null,
    private val onSearch: MockSearchHandler? = null
): OpenMovieDatabase {

    override suspend fun getMovieById(id: String, plot: String?): Movie {
        return onGetMovie?.invoke(id, null, plot)
            ?: error("Unhandled request")
    }

    override suspend fun getMovieByTitle(title: String, year: String?, plot: String?): Movie {
        return onGetMovie?.invoke(title, year, plot)
            ?: error("Unhandled request")
    }

    override suspend fun getSeriesById(id: String, plot: String?): Series {
        return onGetSeries?.invoke(id, null, plot)
            ?: error("Unhandled request")
    }

    override suspend fun getSeriesByTitle(title: String, year: String?, plot: String?): Series {
        return onGetSeries?.invoke(title, year, plot)
            ?: error("Unhandled request")
    }

    override suspend fun getEpisodeById(id: String, plot: String?): Episode {
        return onGetEpisode?.invoke(id, null, plot)
            ?: error("Unhandled request")
    }

    override suspend fun getEpisodeByTitle(title: String, year: String?, plot: String?): Episode {
        return onGetEpisode?.invoke(title, year, plot)
            ?: error("Unhandled request")
    }

    override suspend fun searchFilms(query: String, type: String?, year: String?, page: Int): SearchResult {
        return onSearch?.invoke(query, type, year, page)
            ?: error("Unhandled request")
    }

    companion object {

        /**
         * Create [MockOmdbClient] instance with single [MockSearchHandler].
         */
        fun doOnSearch(handler: MockSearchHandler): OpenMovieDatabase {
            return MockOmdbClient(onSearch = handler)
        }

        /**
         * Create [MockOmdbClient] instance with single [MockFilmHandler].
         */
        fun doOnFindMovie(handler: MockFilmHandler<Movie>): OpenMovieDatabase {
            return MockOmdbClient(onGetMovie = handler)
        }

        /**
         * Create [MockOmdbClient] instance with single [MockFilmHandler].
         */
        fun doOnFindSeries(handler: MockFilmHandler<Series>): OpenMovieDatabase {
            return MockOmdbClient(onGetSeries = handler)
        }

        /**
         * Create [MockOmdbClient] instance with single [MockFilmHandler].
         */
        fun doOnFindEpisode(handler: MockFilmHandler<Episode>): OpenMovieDatabase {
            return MockOmdbClient(onGetEpisode = handler)
        }
    }
}