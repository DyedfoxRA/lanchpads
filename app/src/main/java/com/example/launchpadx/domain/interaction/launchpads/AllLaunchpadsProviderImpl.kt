package com.example.launchpadx.domain.interaction.launchpads

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.response.LaunchpadsResponse
import retrofit2.Response

class AllLaunchpadsProviderImpl(
    private val launchpadsService: LaunchpadsService
) : AllLaunchpadsProvider {

    override suspend fun execute(): Response<LaunchpadsResponse> {
        return launchpadsService.getAllLaunchpads()
    }
}