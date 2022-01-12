package com.example.launchpadx.ui.launchpads_list

import com.example.launchpadx.data.entity.Launchpad

interface LaunchpadListener {
    fun onLaunchpadClick(launchpad: Launchpad)
}