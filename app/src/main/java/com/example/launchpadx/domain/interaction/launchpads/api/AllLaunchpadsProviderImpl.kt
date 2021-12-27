package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.LaunchpadsList
import retrofit2.Response

class AllLaunchpadsProviderImpl(
    private val launchpadsService: LaunchpadsService
) : AllLaunchpadsProvider {

    override suspend fun execute(): Response<LaunchpadsList> {
        return launchpadsService.getAllLaunchpads()
    }
}