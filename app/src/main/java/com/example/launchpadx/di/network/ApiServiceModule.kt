package com.example.launchpadx.di.network

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.di.retrofitService
import org.koin.dsl.module

val apiLaunchpadsServiceModule = module {
    factory { retrofitService<LaunchpadsService>(retrofit = get()) }
}