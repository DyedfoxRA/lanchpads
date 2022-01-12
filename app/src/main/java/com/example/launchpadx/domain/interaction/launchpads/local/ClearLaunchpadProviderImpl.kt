package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadRepository

class ClearLaunchpadProviderImpl(
    private val launchpadRepository: LaunchpadRepository
) : ClearLaunchpadProvider {

    override suspend fun execute() {
        launchpadRepository.clearLaunchpadId()
    }
}
