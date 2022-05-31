package com.example.launchpadx.domain.model

import com.example.launchpadx.framework.base_adapter.Item

data class Launchpad(
    val attemptedLaunches: Int,
    val details: String,
    val id: Long,
    val location: Location,
    val name: String,
    val siteId: String,
    val siteNameLong: String,
    val status: String,
    val successfulLaunches: Int,
    val vehiclesLaunched: List<String>,
    val wikipedia: String
) : Item
