package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.entity.LaunchpadsList
import retrofit2.Response

interface AllLaunchpadsProvider {
    suspend fun execute(): Response<LaunchpadsList>
}