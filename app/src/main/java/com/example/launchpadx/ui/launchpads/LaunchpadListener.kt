package com.example.launchpadx.ui.launchpads

import com.example.launchpadx.data.entity.Launchpad

interface LaunchpadListener {
    fun onLaunchpadClick(launchpad: Launchpad)
}