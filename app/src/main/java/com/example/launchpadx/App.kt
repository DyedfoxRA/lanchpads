package com.example.launchpadx

import android.app.Application
import com.example.launchpadx.di.launchpadModule
import com.example.launchpadx.di.network.apiLaunchpadsServiceModule
import com.example.launchpadx.di.networkModule
import com.example.launchpadx.di.systemModule
import com.example.launchpadx.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    systemModule,
                    viewModule,
                    apiLaunchpadsServiceModule,
                    launchpadModule
                )
            )
        }
    }
}