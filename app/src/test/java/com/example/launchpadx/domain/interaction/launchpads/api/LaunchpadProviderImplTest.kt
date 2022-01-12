package com.example.launchpadx.domain.interaction.launchpads.api

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.entity.Location
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import org.junit.Test
import retrofit2.Response

class LaunchpadProviderImplTest : TestCase() {

    private val launchpadsService: LaunchpadsService = mockk(relaxed = true)
    val launchpadProviderImpl = LaunchpadProviderImpl(launchpadsService)

    // todo check test naming (some problem with adding custom name for test)
    @Test
    fun test() {
        val launchpad = Launchpad(
            1,
            "",
            1,
            Location(1.0, 1.0, "", ""),
            "",
            "",
            "",
            "",
            1,
            emptyList(),
            ""
        )
        val response = Response.success(launchpad)
        coEvery {
            launchpadsService.getOneLaunchpad(any())
        } returns response

        coVerify(exactly = 1) { launchpadProviderImpl.execute(any()) }
    }
}

