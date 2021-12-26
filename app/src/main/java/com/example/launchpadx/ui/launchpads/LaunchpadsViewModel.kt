package com.example.launchpadx.ui.launchpads

import androidx.lifecycle.ViewModel
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.GenericFragmentAction

class LaunchpadsViewModel(
    private val navigator: Navigator,
) : ViewModel() {

    fun navigate(destinationId: Int) {
        navigator.execute(GenericFragmentAction(destinationId))
    }
}