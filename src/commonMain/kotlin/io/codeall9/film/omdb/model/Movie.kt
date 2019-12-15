package io.codeall9.film.omdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("Actors")
    val actors: String,
    @SerialName("Awards")
    val awards: String,
    @SerialName("BoxOffice")
    val boxOffice: String,
    @SerialName("Country")
    val country: String,
    @SerialName("DVD")
    val dvd: String,
    @SerialName("Director")
    val director: String,
    @SerialName("Genre")
    val genre: String,
    @SerialName("imdbID")
    val imdbId: String,
    @SerialName("imdbRating")
    val imdbRating: String,
    @SerialName("imdbVotes")
    val imdbVotes: String,
    @SerialName("Language")
    val language: String,
    @SerialName("Metascore")
    val metaScore: String,
    @SerialName("Plot")
    val plot: String,
    @SerialName("Poster")
    val poster: String,
    @SerialName("Production")
    val production: String,
    @SerialName("Rated")
    val rated: String,
    @SerialName("Ratings")
    val ratings: List<Rating>,
    @SerialName("Released")
    val released: String,
    @SerialName("Response")
    val response: String,
    @SerialName("Runtime")
    val runtime: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Type")
    val type: String,
    @SerialName("Website")
    val website: String,
    @SerialName("Writer")
    val writer: String,
    @SerialName("Year")
    val year: String
)