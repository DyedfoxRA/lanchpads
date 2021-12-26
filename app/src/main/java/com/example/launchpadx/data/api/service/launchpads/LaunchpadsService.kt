package com.example.launchpadx.data.api.service.launchpads

import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.response.LaunchpadsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface LaunchpadsService {

    @GET("launchpads")
    suspend fun getAllLaunchpads(): Response<LaunchpadsResponse>

    @GET("launchpads/{site_id}")
    suspend fun getOneLaunchpad(@Path("site_id") siteId: String): Response<Launchpad>
}