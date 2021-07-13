package com.greeting

import com.greeting.model.GreetingRequest
import com.greeting.model.GreetingResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get
import io.ktor.features.ContentNegotiation
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.serialization.json
import io.ktor.server.netty.EngineMain
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

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
    routing {
        post("/greeting") {
            val greetingRequest = call.receive<GreetingRequest>()
            val ipAddress = client.get<IpAddress>("https://api.ipify.org?format=json")
            call.respond(GreetingResponse("Hello ${greetingRequest.firstName} ${greetingRequest.lastName}", ipAddress.ip))
        }
    }
}

@Serializable
class IpAddress(var ip: String)
