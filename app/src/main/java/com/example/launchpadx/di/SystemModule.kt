package com.example.launchpadx.di

import androidx.preference.PreferenceManager
import com.example.launchpadx.navigation.CustomNavigator
import com.example.launchpadx.navigation.Navigator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val systemModule = module {
    single<Navigator> { CustomNavigator(app = get()) }

    single { PreferenceManager.getDefaultSharedPreferences(androidContext()) }
}
