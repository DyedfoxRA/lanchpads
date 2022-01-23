package com.example.launchpadx.domain.interaction.launchpads.local

import com.example.launchpadx.domain.interaction.launchpads.LaunchpadLocalRepository

class GetLaunchpadProviderImpl(
    private val launchpadLocalRepository: LaunchpadLocalRepository
) : GetLaunchpadProvider {

    override suspend fun execute(): String {
        return launchpadLocalRepository.getLaunchpadId()
    }
}
