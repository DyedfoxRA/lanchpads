package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.domain.model.Launchpad

interface LaunchpadProvider {
    suspend fun execute(siteId: String): Launchpad
}
