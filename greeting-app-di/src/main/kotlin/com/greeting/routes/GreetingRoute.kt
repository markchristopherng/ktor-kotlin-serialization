package com.greeting.routes

import com.greeting.model.GreetingRequest
import com.greeting.service.GreetingService
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.routing
import org.koin.ktor.ext.inject

fun Route.postGreeting() {

    val greetingService by inject<GreetingService>()

    post("/greeting") {
        val greetingRequest = call.receive<GreetingRequest>()
        call.respond(greetingService.greeting(greetingRequest))
    }
}

fun Application.registerGreetingRoutes() {
    routing {
        postGreeting()
    }
}
