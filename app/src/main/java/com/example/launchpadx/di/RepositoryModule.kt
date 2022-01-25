package com.example.launchpadx.di

import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.data.repo.remote.LaunchpadsRemoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<LaunchpadRepository> {
        LaunchpadsRemoteRepository(
            launchpadsService = get(),
            launchpadEntityToLaunchpadMapper = get(),
            ioDispatcher = get()
        )
    }
}
