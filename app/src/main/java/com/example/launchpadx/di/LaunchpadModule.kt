package com.example.launchpadx.di

import com.example.launchpadx.domain.interaction.launchpads.AllLaunchpadsProvider
import com.example.launchpadx.domain.interaction.launchpads.AllLaunchpadsProviderImpl
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadProviderImpl
import org.koin.dsl.module

val launchpadModule = module {
    single<AllLaunchpadsProvider> { AllLaunchpadsProviderImpl(launchpadsService = get()) }
    single<LaunchpadProvider> { LaunchpadProviderImpl(launchpadsService = get()) }
}