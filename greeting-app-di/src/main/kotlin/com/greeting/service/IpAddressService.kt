package com.greeting.service

import com.greeting.routes.IpAddress
import io.ktor.client.HttpClient
import io.ktor.client.request.get

interface IpAddressService {
    suspend fun getIpAddress(): IpAddress
}

class IpAddressServiceImpl(private val client: HttpClient) : IpAddressService {

    override suspend fun getIpAddress(): IpAddress {
        return client.get("https://api.ipify.org?format=json")
    }
}
