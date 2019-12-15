package io.codeall9.film.omdb.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorStatus(
    @SerialName("Response")
    private val response: String,
    @SerialName("Error")
    val message: String
)