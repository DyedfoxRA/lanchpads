package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadRepository

class GetLaunchpadProviderImpl(
    private val launchpadRepository: LaunchpadRepository
) : GetLaunchpadProvider {

    override suspend fun execute(): String {
        return launchpadRepository.getLaunchpadId()
    }
}