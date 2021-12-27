package com.example.launchpadx.framework.data.repository

import android.content.SharedPreferences
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadRepository

class LaunchpadSharedPrefsRepository(
    private val sharedPrefs: SharedPreferences
) : LaunchpadRepository {

    companion object {
        private const val KEY_LAUNCHPAD_ID = "KEY_LAUNCHPAD_ID"
    }

    override suspend fun saveLaunchpadId(siteId: String) {
        sharedPrefs.edit().putString(KEY_LAUNCHPAD_ID, siteId).apply()
    }

    override suspend fun getLaunchpadId(): String {
        return sharedPrefs.getString(KEY_LAUNCHPAD_ID, "").orEmpty()
    }

    override suspend fun clearLaunchpadId() {
        sharedPrefs.edit().remove(KEY_LAUNCHPAD_ID).apply()
    }
}