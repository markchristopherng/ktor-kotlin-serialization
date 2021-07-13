package com.greeting.service

import com.greeting.model.GreetingRequest
import com.greeting.model.GreetingResponse

interface GreetingService {
    suspend fun greeting(request: GreetingRequest): GreetingResponse
}

class GreetingServiceImpl(private val ipAddressService: IpAddressService) : GreetingService {

    override suspend fun greeting(request: GreetingRequest): GreetingResponse {
        val ipAddress = ipAddressService.getIpAddress()
        return GreetingResponse("Hello ${request.firstName} ${request.lastName}", ipAddress.ip)
    }
}
