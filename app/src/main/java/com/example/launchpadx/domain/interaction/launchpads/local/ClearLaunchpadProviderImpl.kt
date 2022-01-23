package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadLocalRepository

class ClearLaunchpadProviderImpl(
    private val launchpadLocalRepository: LaunchpadLocalRepository
) : ClearLaunchpadProvider {

    override suspend fun execute(): Boolean {
        return launchpadLocalRepository.clearLaunchpadId()
    }
}
