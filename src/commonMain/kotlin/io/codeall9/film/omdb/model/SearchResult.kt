package io.codeall9.film.omdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("Search")
    val results: List<FilmInfo>,
    @SerialName("totalResults")
    private val totalResults: String,
    @SerialName("Response")
    private val response: String
) {
    val total get() = totalResults.toInt()
}