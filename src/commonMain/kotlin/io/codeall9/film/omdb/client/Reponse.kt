package io.codeall9.film.omdb.client

import io.codeall9.film.omdb.exception.OpenMovieException
import io.codeall9.film.omdb.model.ErrorStatus
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal val omdbJsonFormat by lazy { createOmdbJsonFormat() }

internal fun createOmdbJsonFormat(): Json {
    return Json {
        isLenient = true
        ignoreUnknownKeys = true
        allowSpecialFloatingPointValues = true
        useArrayPolymorphism = true
    }
}

internal inline fun <reified T> JsonElement.parseOmdbJson(): T {
    return omdbJsonFormat.decodeFromJsonElement(this)
}

internal fun String.toOmdbJsonElement(): JsonElement = omdbJsonFormat.parseToJsonElement(this)

internal suspend inline fun <reified T> HttpResponse.parseOmdbResponse(): T {
    val element = readOmdbJsonElement()
    return element.takeIf { it.isResponseSuccess() }
        ?.parseOmdbJson<T>()
        ?: throw OpenMovieException(element.parseOmdbJson())
}

private suspend fun HttpResponse.readOmdbJsonElement(): JsonElement = readText().toOmdbJsonElement()

private fun JsonElement.isResponseSuccess(): Boolean {
    return jsonObject["Response"]?.let { it.jsonPrimitive.content == "True" } == true
}