package org.dependencytrack.vulnmirror.datasource.csaf

import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.*
import io.ktor.serialization.kotlinx.json.*

object CsafHttpClientFactory {
    val client: HttpClient by lazy {
        HttpClient(Java) {
            expectSuccess = true
            install(ContentNegotiation) {
                json()
            }
            install(HttpRequestRetry) {
                retryOnExceptionOrServerErrors(maxRetries = 5)
                retryIf(maxRetries = 5) { request, response -> response.status.value == 429 }
                exponentialDelay(baseDelayMs = 5000)
            }
        }
    }
}