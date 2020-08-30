package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.api.FilmType
import io.codeall9.film.omdb.api.OmdbApi
import io.ktor.client.statement.*

private const val FORMAT_JSON = "json"

/**
 * Search movie
 * @see [OmdbApi.getDetail]
 */
internal suspend fun OmdbApi.getMovie(
        id: String? = null,
        title: String? = null,
        year: String?,
        plot: String?,
        format: String? = FORMAT_JSON
): HttpResponse = getDetail(id, title, FilmType.MOVIE, year, plot, format)

/**
 * Search series
 * @see [OmdbApi.getDetail]
 */
internal suspend fun OmdbApi.getSeries(
        id: String? = null,
        title: String? = null,
        year: String?,
        plot: String?,
        format: String? = FORMAT_JSON
): HttpResponse = getDetail(id, title, FilmType.SERIES, year, plot, format)

/**
 * Search episode
 * @see [OmdbApi.getDetail]
 */
internal suspend fun OmdbApi.getEpisode(
        id: String? = null,
        title: String? = null,
        year: String?,
        plot: String?,
        format: String? = FORMAT_JSON
): HttpResponse = getDetail(id, title, FilmType.EPISODE, year, plot, format)


/**
 * Search films
 * @see [OmdbApi.searchFilms]
 */
internal suspend fun OmdbApi.searchFilms(
        query: String,
        type: String?,
        year: String?,
        page: Int = 1,
        format: String? = FORMAT_JSON,
): HttpResponse = searchFilms(query, type, year, format, page)