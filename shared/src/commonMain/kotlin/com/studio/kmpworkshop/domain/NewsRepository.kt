package com.studio.kmpworkshop.domain

import com.studio.kmpworkshop.data.NewsDTO
import com.studio.kmpworkshop.data.newsJson
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.seconds

class NewsRepository {

    private val json: Json = Json {
        ignoreUnknownKeys = true
    }

    suspend fun fetchNews(): List<News> {
        delay(1.5.seconds)
        return json.decodeFromString<List<NewsDTO>>(newsJson)
            .map { it.mapToNews() }
    }

    private fun NewsDTO.mapToNews(): News =
        News(
            title = title,
            formattedDate = DateFormatter.getStringTime(timeInSeconds = time),
            url = url,
        )
}
