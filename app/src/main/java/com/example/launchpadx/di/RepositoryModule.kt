package com.example.launchpadx.di

import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.data.repo.remote.LaunchpadsRemoteRepository
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadLocalRepository
import com.example.launchpadx.framework.data.repository.LaunchpadSharedPrefsLocalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<LaunchpadLocalRepository> { LaunchpadSharedPrefsLocalRepository(sharedPrefs = get()) }
    single<LaunchpadRepository> {
        LaunchpadsRemoteRepository(
            launchpadsService = get(),
            launchpadEntityToLaunchpadMapper = get(),
            ioDispatcher = get()
        )
    }
}
