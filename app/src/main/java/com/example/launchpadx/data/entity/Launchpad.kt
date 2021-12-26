package com.example.launchpadx.data.entity


import com.example.launchpadx.ui.base.adapter.ListAdapterItem
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Launchpad(
    @Json(name = "attempted_launches")
    val attemptedLaunches: Int,
    @Json(name = "details")
    val details: String,
    @Json(name = "id")
    val idLaunchpad: Int,
    @Json(name = "location")
    val location: Location,
    @Json(name = "site_id")
    val siteId: String,
    @Json(name = "site_name_long")
    val siteNameLong: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "successful_launches")
    val successfulLaunches: Int,
    @Json(name = "vehicles_launched")
    val vehiclesLaunched: List<String>,
    @Json(name = "wikipedia")
    val wikipedia: String,
    override val id: Long = 0
): ListAdapterItem