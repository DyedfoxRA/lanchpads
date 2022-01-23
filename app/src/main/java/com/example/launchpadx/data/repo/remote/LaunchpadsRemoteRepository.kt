package com.example.launchpadx.data.repo.remote

import androidx.annotation.WorkerThread
import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.LaunchpadsList
import com.example.launchpadx.data.safeExecute
import com.example.launchpadx.domain.mapppers.launchpad.LaunchpadEntityToLaunchpadMapper
import com.example.launchpadx.domain.model.Launchpad
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class LaunchpadsRemoteRepository(
    private val launchpadsService: LaunchpadsService,
    private val launchpadEntityToLaunchpadMapper: LaunchpadEntityToLaunchpadMapper,
    private val ioDispatcher: CoroutineDispatcher
) : LaunchpadRepository {

    @WorkerThread
    override fun getAllLaunchpads(
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<Launchpad>> = flow {
        safeExecute<LaunchpadsList> {
            request = { launchpadsService.getAllLaunchpads1() }
            success = { launchpadList ->
                emit(launchpadList.map(launchpadEntityToLaunchpadMapper::map))
            }
            error = { error -> onError(error.message) }
        }
    }
        .onStart { onStart() }
        .onCompletion { onComplete() }
        .flowOn(ioDispatcher)

    override suspend fun getLaunchpad(siteId: String): Launchpad {
        return launchpadEntityToLaunchpadMapper
            .map(launchpadsService.getOneLaunchpad(siteId))
    }
}
