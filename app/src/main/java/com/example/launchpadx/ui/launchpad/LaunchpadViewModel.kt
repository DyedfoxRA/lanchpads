package com.example.launchpadx.ui.launchpad

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.safeExecute
import com.example.launchpadx.domain.interaction.launchpads.LaunchpadProvider
import com.example.launchpadx.navigation.Navigator
import kotlinx.coroutines.launch

class LaunchpadViewModel(
    private val navigator: Navigator,
    private val launchpadProvider: LaunchpadProvider
) : ViewModel() {

    val launchpad = MutableLiveData<Launchpad>()

    fun loadLaunchpad(siteId: String){
        viewModelScope.launch {
            safeExecute<Launchpad> {
                request = {
                    launchpadProvider.execute(siteId)
                }
                error = {}
                success = {
                    launchpad.value = it
                }
            }
        }
    }
}