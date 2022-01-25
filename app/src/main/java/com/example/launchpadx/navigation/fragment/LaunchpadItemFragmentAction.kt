package com.example.launchpadx.navigation.fragment

import android.app.Activity
import androidx.navigation.findNavController
import com.example.launchpadx.R
import com.example.launchpadx.navigation.NavigationAction
import com.example.launchpadx.ui.launchpad_item.LaunchpadItemFragmentDirections

class LaunchpadItemFragmentAction(private val siteId: String) : NavigationAction {

    override fun execute(activity: Activity) {
        val action = LaunchpadItemFragmentDirections.actionGlobalLaunchpadFragment(siteId)
        activity.findNavController(R.id.nav_fragment).navigate(action)
    }
}
