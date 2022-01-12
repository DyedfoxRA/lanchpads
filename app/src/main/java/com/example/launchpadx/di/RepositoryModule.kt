package com.example.launchpadx.di

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadRepository
import com.example.launchpadx.framework.data.repository.LaunchpadSharedPrefsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<LaunchpadRepository> { LaunchpadSharedPrefsRepository(sharedPrefs = get()) }
}