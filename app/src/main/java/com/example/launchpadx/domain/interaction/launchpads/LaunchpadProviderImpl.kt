package com.example.launchpadx.domain.interaction.launchpads

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.Launchpad
import retrofit2.Response

class LaunchpadProviderImpl(
    private val launchpadsService: LaunchpadsService
) : LaunchpadProvider {

    override suspend fun execute(siteId: String): Response<Launchpad> {
        return launchpadsService.getOneLaunchpad(siteId)
    }
}