package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadLocalRepository

class SaveLaunchpadProviderImpl(
    private val launchpadLocalRepository: LaunchpadLocalRepository
) : SaveLaunchpadProvider {

    override suspend fun execute(siteId: String): Boolean {
        return launchpadLocalRepository.saveLaunchpadId(siteId)
    }
}
