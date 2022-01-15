package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadRepository

class SaveLaunchpadProviderImpl(
    private val launchpadRepository: LaunchpadRepository
) : SaveLaunchpadProvider {

    override suspend fun execute(siteId: String): Boolean {
        return launchpadRepository.saveLaunchpadId(siteId)
    }
}
