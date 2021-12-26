package com.example.launchpadx.domain.interaction.launchpads

import com.example.launchpadx.data.entity.Launchpad
import retrofit2.Response

interface LaunchpadProvider {
    suspend fun execute(siteId: String): Response<Launchpad>
}