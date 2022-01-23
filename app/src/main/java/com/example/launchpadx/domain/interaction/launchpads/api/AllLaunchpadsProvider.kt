package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.domain.model.Launchpad

interface AllLaunchpadsProvider {
    suspend fun execute(): List<Launchpad>
}
