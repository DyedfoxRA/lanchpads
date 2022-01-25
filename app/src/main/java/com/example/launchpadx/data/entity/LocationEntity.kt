package com.example.launchpadx.data.entity

import com.google.gson.annotations.SerializedName

data class LocationEntity(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String
)
