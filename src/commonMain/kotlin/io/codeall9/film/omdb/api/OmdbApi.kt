package io.codeall9.film.omdb.api

import io.ktor.client.statement.HttpResponse

private const val FORMAT_JSON = "json"
private const val VERSION = "1"

interface OmdbApi {

    /**
     * Search by [id] or [title], both [id] and [title] are optional at least one argument is required.
     *
     * @param id A valid IMDb ID. e.g. tt1285016
     * @param title Movie title to search for.
     * @param type Type of result to return. e.g. movie, series, episode
     * @param year Year of release.
     * @param plot Return short or full plot. e.g. short, full
     * @param format The data type to return. e.g. json, xml
     * @param version API version (reserved for future use).
     */
    suspend fun getDetail(
        id: String?,
        title: String?,
        type: String?,
        year: String?,
        plot: String?,
        format: String?,
        version: String = VERSION
    ): HttpResponse

    /**
     * Search by [query]
     *
     * @param query Movie title to search for. Parameter name: s
     * @param type Type of result to return. e.g. movie, series, episode
     * @param year Year of release.
     * @param format The data type to return. e.g. json, xml
     * @param page Page number to return. e.g. 1-100.
     * @param version API version (reserved for future use).
     *
     */
    suspend fun searchFilms(
        query: String,
        type: String?,
        year: String?,
        format: String?,
        page: Int = 1,
        version: String = VERSION
    ): HttpResponse
}

/**
 * Search movie
 * @see [OmdbApi.getDetail]
 */
suspend fun OmdbApi.getMovie(
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
suspend fun OmdbApi.getSeries(
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
suspend fun OmdbApi.getEpisode(
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
suspend fun OmdbApi.searchFilms(
    query: String,
    type: String?,
    year: String?,
    page: Int = 1,
    format: String? = FORMAT_JSON,
    version: String = VERSION
): HttpResponse = searchFilms(query, type, year, format, page, version)