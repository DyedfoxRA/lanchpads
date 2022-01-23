package com.example.launchpadx.data.api.service.launchpads

import com.example.launchpadx.data.entity.LaunchpadEntity
import com.example.launchpadx.data.entity.LaunchpadsList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchpadsService {

    @GET("launchpads")
    suspend fun getAllLaunchpads(): LaunchpadsList

    @GET("launchpads")
    suspend fun getAllLaunchpads1(): Response<LaunchpadsList>

    @GET("launchpads/{site_id}")
    suspend fun getOneLaunchpad(@Path("site_id") siteId: String): LaunchpadEntity
}
