package com.example.launchpadx.domain.interaction.launchpads

interface LaunchpadRepository {
    suspend fun saveLaunchpadId(siteId: String)
    suspend fun getLaunchpadId(): String
    suspend fun clearLaunchpadId()
}
