package com.example.launchpadx.domain.model

import com.example.launchpadx.ui.base.adapter.ListAdapterItem

data class Launchpad(
    val attemptedLaunches: Int,
    val details: String,
    override val id: Long,
    val location: Location,
    val name: String,
    val siteId: String,
    val siteNameLong: String,
    val status: String,
    val successfulLaunches: Int,
    val vehiclesLaunched: List<String>,
    val wikipedia: String
) : ListAdapterItem
