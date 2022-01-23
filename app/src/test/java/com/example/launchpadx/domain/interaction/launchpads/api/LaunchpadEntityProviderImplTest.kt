package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.LaunchpadEntity
import com.example.launchpadx.data.entity.LocationEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.Response

class LaunchpadEntityProviderImplTest : TestCase() {

    private val launchpadsService: LaunchpadsService = mockk(relaxed = true)
    val launchpadProviderImpl = LaunchpadProviderImpl(launchpadsService)

    // todo check test naming (some problem with adding custom name for test)
    @Test
    fun test() = runBlocking {
        val launchpad = LaunchpadEntity(
            1,
            "",
            1,
            LocationEntity(1.0, 1.0, "", ""),
            "",
            "",
            "",
            "",
            1,
            emptyList(),
            ""
        )
        val response = Response.success(launchpad)
        coEvery { launchpadsService.getOneLaunchpad(any()) } returns response
        val realResult = launchpadProviderImpl.execute("")
        coVerify { launchpadProviderImpl.execute(any()) }
        coVerify { launchpadProviderImpl.execute("") }

        assertTrue(realResult == response)
    }
}
