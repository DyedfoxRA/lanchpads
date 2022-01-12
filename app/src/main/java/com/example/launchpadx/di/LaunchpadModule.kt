package com.example.launchpadx.di

import com.example.launchpadx.domain.interaction.launchpads.api.AllLaunchpadsProvider
import com.example.launchpadx.domain.interaction.launchpads.api.AllLaunchpadsProviderImpl
import com.example.launchpadx.domain.interaction.launchpads.api.LaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.api.LaunchpadProviderImpl
import com.example.launchpadx.domain.interaction.launchpads.local.ClearLaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.local.ClearLaunchpadProviderImpl
import com.example.launchpadx.domain.interaction.launchpads.local.GetLaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.local.GetLaunchpadProviderImpl
import com.example.launchpadx.domain.interaction.launchpads.local.SaveLaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.local.SaveLaunchpadProviderImpl
import org.koin.dsl.module

val launchpadModule = module {
    single<AllLaunchpadsProvider> { AllLaunchpadsProviderImpl(launchpadsService = get()) }
    single<LaunchpadProvider> { LaunchpadProviderImpl(launchpadsService = get()) }
    single<GetLaunchpadProvider> { GetLaunchpadProviderImpl(launchpadRepository = get()) }
    single<SaveLaunchpadProvider> { SaveLaunchpadProviderImpl(launchpadRepository = get()) }
    single<ClearLaunchpadProvider> { ClearLaunchpadProviderImpl(launchpadRepository = get()) }
}
