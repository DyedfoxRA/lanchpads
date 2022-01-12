package com.example.launchpadx.di

import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.launchpadx.navigation.CustomNavigator
import com.example.launchpadx.navigation.Navigator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

val systemModule = module {
    single<Navigator> { CustomNavigator(app = get()) }

    single<SharedPreferences> {
        EncryptedSharedPreferences.create(
            "secret_shared_prefs",
            masterKeyAlias,
            androidContext(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

}