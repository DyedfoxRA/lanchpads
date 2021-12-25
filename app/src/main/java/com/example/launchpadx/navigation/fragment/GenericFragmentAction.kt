package com.example.launchpadx.navigation.fragment

import android.app.Activity
import androidx.navigation.findNavController
import com.example.launchpadx.R
import com.example.launchpadx.navigation.NavigationAction

class GenericFragmentAction(private val destinationId: Int) : NavigationAction {
    override fun execute(activity: Activity) {

        activity.findNavController(R.id.nav_fragment).navigate(destinationId)
    }
}
