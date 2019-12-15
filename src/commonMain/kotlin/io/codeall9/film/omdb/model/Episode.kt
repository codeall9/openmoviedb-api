package io.codeall9.film.omdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Episode(
    @SerialName("Actors")
    val actors: String,
    @SerialName("Awards")
    val awards: String,
    @SerialName("Country")
    val country: String,
    @SerialName("Director")
    val director: String,
    @SerialName("Episode")
    val episode: String,
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
    @SerialName("Rated")
    val rated: String,
    @SerialName("Ratings")
    val ratings: List<Rating>,
    @SerialName("Released")
    val released: String,
    @SerialName("Runtime")
    val runtime: String,
    @SerialName("Season")
    val season: String,
    @SerialName("seriesID")
    val seriesID: String,
    @SerialName("Title")
    val title: String,
    @SerialName("Type")
    val type: String,
    @SerialName("Writer")
    val writer: String,
    @SerialName("Year")
    val year: String,
    @SerialName("Response")
    val response: String
)