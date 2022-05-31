package com.example.launchpadx.data.repo.remote

import com.example.launchpadx.domain.model.Launchpad
import kotlinx.coroutines.flow.Flow

interface LaunchpadRepository {
    fun getAllLaunchpads(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Launchpad>>

    fun getLaunchpad(
        siteId: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<Launchpad>
}
