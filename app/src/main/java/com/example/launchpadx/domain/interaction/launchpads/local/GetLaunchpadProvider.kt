package com.example.launchpadx.domain.interaction.launchpads.local

interface GetLaunchpadProvider {
    suspend fun execute(): String
}