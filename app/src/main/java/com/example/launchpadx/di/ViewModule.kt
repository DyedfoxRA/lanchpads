package com.example.launchpadx.di

import com.example.launchpadx.ui.launchpad_item.LaunchpadItemViewModel
import com.example.launchpadx.ui.launchpads_list.LaunchpadsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {

    viewModel {
        LaunchpadItemViewModel(
            navigator = get(),
            launchpadProvider = get(),
            getLaunchpadProvider = get()
        )
    }
    viewModel {
        LaunchpadsListViewModel(
            navigator = get(),
            allLaunchpadsProvider = get(),
            saveLaunchpadProvider = get()
        )
    }
}