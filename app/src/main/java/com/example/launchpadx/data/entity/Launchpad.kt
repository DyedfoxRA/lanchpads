package com.example.launchpadx.data.entity


import com.example.launchpadx.ui.base.adapter.ListAdapterItem
import com.google.gson.annotations.SerializedName

data class Launchpad(
    @SerializedName("attempted_launches")
    val attemptedLaunches: Int,
    @SerializedName("details")
    val details: String,
    @SerializedName("id")
    override val id: Long,
    @SerializedName("location")
    val location: Location,
    @SerializedName("name")
    val name: String,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("site_name_long")
    val siteNameLong: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("successful_launches")
    val successfulLaunches: Int,
    @SerializedName("vehicles_launched")
    val vehiclesLaunched: List<String>,
    @SerializedName("wikipedia")
    val wikipedia: String
): ListAdapterItem