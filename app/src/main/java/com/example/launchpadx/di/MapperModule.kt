package com.example.launchpadx.di

import com.example.launchpadx.domain.mapppers.launchpad.LaunchpadEntityToLaunchpadMapper
import com.example.launchpadx.domain.mapppers.launchpad.LaunchpadEntityToLaunchpadMapperImpl
import com.example.launchpadx.domain.mapppers.location.LocationEntityToLocationMapper
import com.example.launchpadx.domain.mapppers.location.LocationEntityToLocationMapperImpl
import org.koin.dsl.module

val mapperModule = module {
    single<LocationEntityToLocationMapper> { LocationEntityToLocationMapperImpl() }
    single<LaunchpadEntityToLaunchpadMapper> {
        LaunchpadEntityToLaunchpadMapperImpl(locationEntityToLocationMapper = get())
    }
}
