package com.example.launchpadx.di

import com.example.launchpadx.navigation.CustomNavigator
import com.example.launchpadx.navigation.Navigator
import org.koin.dsl.module

val systemModule = module {
    single<Navigator> { CustomNavigator(app = get()) }
}