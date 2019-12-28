package io.codeall9.film.omdb.client

class SearchQuery internal constructor(
    private val db: OpenMovieDatabase,
    private val query: String,
    private val year: String? = null
) {

    suspend fun getMovieResult(page: Int = 1) = db.searchFilms(query, OmdbClient.TYPE_MOVIE, year, page)

    suspend fun getSeriesResult(page: Int = 1) = db.searchFilms(query, OmdbClient.TYPE_SERIES, year, page)

    suspend fun getEpisodeResult(page: Int = 1) = db.searchFilms(query, OmdbClient.TYPE_EPISODE, year, page)

    suspend fun getResult(page: Int = 1) = db.searchFilms(query, null, year, page)
}

fun OpenMovieDatabase.getQuery(
    query: String,
    year: String? = null
) = SearchQuery(this@getQuery, query, year)