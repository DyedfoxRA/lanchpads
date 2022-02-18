package com.example.launchpadx.data.repo.remote

import com.example.launchpadx.data.api.service.launchpads.LaunchpadsService
import com.example.launchpadx.data.entity.LaunchpadEntity
import com.example.launchpadx.data.entity.LocationEntity
import com.example.launchpadx.domain.mapppers.launchpad.LaunchpadEntityToLaunchpadMapperImpl
import com.example.launchpadx.domain.mapppers.location.LocationEntityToLocationMapperImpl
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.domain.model.Location
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class LaunchpadsRemoteRepositoryTest : TestCase() {

    private val service: LaunchpadsService = mockk()
    private val localMapper: LocationEntityToLocationMapperImpl = mockk()
    private val mapper = LaunchpadEntityToLaunchpadMapperImpl(localMapper)
    private val repo = LaunchpadsRemoteRepository(service, mapper, Dispatchers.IO)
    private val launchpad = Launchpad(
        1,
        "qwe",
        1,
        Location(1.0, 1.0, "qwe", "qwe"),
        "qwe",
        "qwe",
        "qwe",
        "qwe",
        1,
        emptyList(),
        "qwe"
    )
    private val launchpadEntity = LaunchpadEntity(
        1,
        "qwe",
        1,
        LocationEntity(1.0, 1.0, "qwe", "qwe"),
        "qwe",
        "qwe",
        "qwe",
        "qwe",
        1,
        emptyList(),
        "qwe"
    )

    @Before
    fun set() {
        MockKAnnotations.init(this)
    }

    @Test
    fun check() = runBlocking {
        coEvery { service.getOneLaunchpad("123") } returns Response.success(launchpadEntity)
        coEvery { localMapper.map(launchpadEntity.locationEntity) } returns launchpad.location
        val res = repo.getLaunchpad("123", {}, {}, {}).first()
        assertNotNull(res)
        assertEquals(launchpadEntity.details, res.details)
        assertEquals(launchpad, res)
    }
}
