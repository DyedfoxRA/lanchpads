package com.example.launchpadx.di

import com.example.launchpadx.ui.launchpad.LaunchpadViewModel
import com.example.launchpadx.ui.launchpads.LaunchpadsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {

    viewModel { LaunchpadViewModel(navigator = get(), launchpadProvider = get()) }
    viewModel { LaunchpadsViewModel(navigator = get(), allLaunchpadsProvider = get())}
}