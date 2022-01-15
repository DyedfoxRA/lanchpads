package com.example.launchpadx.domain.interaction.launchpads

interface LaunchpadRepository {
    suspend fun saveLaunchpadId(siteId: String): Boolean
    suspend fun getLaunchpadId(): String
    suspend fun clearLaunchpadId(): Boolean
}
