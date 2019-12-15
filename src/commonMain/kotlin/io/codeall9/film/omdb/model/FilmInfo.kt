package io.codeall9.film.omdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmInfo(
    @SerialName("imdbID")
    val imdbId: String,
    @SerialName("Poster")
    val poster: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Type")
    val type: String,
    @SerialName("Year")
    val year: String
)
