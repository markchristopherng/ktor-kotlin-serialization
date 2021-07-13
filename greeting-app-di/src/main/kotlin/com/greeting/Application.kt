package com.greeting

import com.greeting.routes.registerGreetingRoutes
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.features.ContentNegotiation
import io.ktor.serialization.json
import io.ktor.server.netty.EngineMain
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {

    val jsonParser = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    install(ContentNegotiation) {
        json(jsonParser)
    }
    val client = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = KotlinxSerializer(jsonParser)
        }
    }
    install(Koin) {
        slf4jLogger()
        modules(org.koin.dsl.module { single { client }; single { jsonParser } }, greetingModule)
    }
    registerGreetingRoutes()
}
