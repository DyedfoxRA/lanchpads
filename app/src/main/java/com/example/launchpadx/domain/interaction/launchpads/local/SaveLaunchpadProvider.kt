package com.example.launchpadx.domain.interaction.launchpads.local

interface SaveLaunchpadProvider {
    suspend fun execute(siteId: String)
}