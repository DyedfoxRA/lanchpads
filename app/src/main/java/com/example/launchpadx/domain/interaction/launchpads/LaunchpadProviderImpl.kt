package com.example.launchpadx.domain.interaction.launchpads

import com.example.launchpadx.data.entity.Launchpad
import retrofit2.Response

class LaunchpadProviderImpl(
    private val launchpadProvider: LaunchpadProvider
) : LaunchpadProvider {

    override suspend fun execute(siteId: String): Response<Launchpad> {
        return launchpadProvider.execute(siteId)
    }
}