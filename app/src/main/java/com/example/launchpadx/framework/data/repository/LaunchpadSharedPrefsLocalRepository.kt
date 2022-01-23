package com.example.launchpadx.framework.data.repository

import android.content.SharedPreferences
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadLocalRepository

class LaunchpadSharedPrefsLocalRepository(
    private val sharedPrefs: SharedPreferences
) : LaunchpadLocalRepository {

    companion object {
        private const val KEY_LAUNCHPAD_ID = "KEY_LAUNCHPAD_ID"
    }

    override suspend fun saveLaunchpadId(siteId: String): Boolean {
        return sharedPrefs.edit().putString(KEY_LAUNCHPAD_ID, siteId).commit()
    }

    override suspend fun getLaunchpadId(): String {
        return sharedPrefs.getString(KEY_LAUNCHPAD_ID, "").orEmpty()
    }

    override suspend fun clearLaunchpadId(): Boolean {
        return sharedPrefs.edit().remove(KEY_LAUNCHPAD_ID).commit()
    }
}
