package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.repo.remote.LaunchpadRepository

class AllLaunchpadsProviderImpl(
    private val launchpadRepository: LaunchpadRepository
)
//    : AllLaunchpadsProvider {
//
//    override suspend fun execute(): List<Launchpad> {
//        return launchpadRepository.getAllLaunchpads()
//    }
// }
