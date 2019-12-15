package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.model.Episode
import io.codeall9.film.omdb.model.Movie
import io.codeall9.film.omdb.model.SearchResult
import io.codeall9.film.omdb.model.Series

interface OpenMovieDatabase {

    suspend fun getMovieById(id: String, year: String? = null, plot: String? = null): Movie

    suspend fun getMovieByTitle(title: String, year: String? = null, plot: String? = null): Movie

    suspend fun getSeriesById(id: String, year: String? = null, plot: String? = null): Series

    suspend fun getSeriesByTitle(title: String, year: String? = null, plot: String? = null): Series

    suspend fun getEpisodeById(id: String, year: String? = null, plot: String? = null): Episode

    suspend fun getEpisodeByTitle(title: String, year: String? = null, plot: String? = null): Episode

    suspend fun searchFilms(query: String, type: String? = null, year: String? = null, page: Int = 1): SearchResult
}