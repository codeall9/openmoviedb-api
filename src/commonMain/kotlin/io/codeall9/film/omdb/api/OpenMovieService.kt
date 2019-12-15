package io.codeall9.film.omdb.api

import io.codeall9.film.omdb.api.OmdbParameters.FORMAT
import io.codeall9.film.omdb.api.OmdbParameters.IMDB_ID
import io.codeall9.film.omdb.api.OmdbParameters.PAGE
import io.codeall9.film.omdb.api.OmdbParameters.PLOT
import io.codeall9.film.omdb.api.OmdbParameters.RESULT_TYPE
import io.codeall9.film.omdb.api.OmdbParameters.SEARCH
import io.codeall9.film.omdb.api.OmdbParameters.TITLE
import io.codeall9.film.omdb.api.OmdbParameters.VERSION
import io.codeall9.film.omdb.api.OmdbParameters.YEAR
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.response.HttpResponse

internal class OpenMovieService (private val client: HttpClient) : OmdbApi {

    override suspend fun getDetail(
        id: String?,
        title: String?,
        type: String?,
        year: String?,
        plot: String?,
        format: String?,
        version: String
    ): HttpResponse = client.get {
        parameter(IMDB_ID, id)
        parameter(TITLE, title)
        parameter(RESULT_TYPE, type)
        parameter(YEAR, year)
        parameter(PLOT, plot)
        parameter(FORMAT, format)
        parameter(VERSION, version)
    }

    override suspend fun searchFilms(
        query: String,
        type: String?,
        year: String?,
        format: String?,
        page: Int,
        version: String
    ): HttpResponse = client.get {
        parameter(SEARCH, query)
        parameter(RESULT_TYPE, type)
        parameter(YEAR, year)
        parameter(FORMAT, format)
        parameter(PAGE, page)
        parameter(VERSION, version)
    }
}