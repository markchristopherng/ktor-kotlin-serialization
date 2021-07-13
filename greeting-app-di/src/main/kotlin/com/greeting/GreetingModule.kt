package com.greeting

import com.greeting.service.GreetingService
import com.greeting.service.GreetingServiceImpl
import com.greeting.service.IpAddressService
import com.greeting.service.IpAddressServiceImpl
import org.koin.dsl.module

val greetingModule = module(createdAtStart = true) {
    single<GreetingService> { GreetingServiceImpl(get()) }
    single<IpAddressService> { IpAddressServiceImpl(get()) }
}
