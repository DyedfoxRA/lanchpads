package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.domain.model.Launchpad

class LaunchpadProviderImpl(
    private val launchpadRepository: LaunchpadRepository
) : LaunchpadProvider {

    override suspend fun execute(siteId: String): Launchpad {
        return launchpadRepository.getLaunchpad(siteId)
    }
}
