package com.example.launchpadx.ui.launchpads_list

import com.example.launchpadx.domain.model.Launchpad

interface LaunchpadListener {
    fun onLaunchpadClick(launchpad: Launchpad)
}
