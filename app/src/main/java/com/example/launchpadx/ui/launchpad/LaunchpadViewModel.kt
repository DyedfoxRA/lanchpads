package com.example.launchpadx.ui.launchpad

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.safeExecute
import com.example.launchpadx.domain.interaction.launchpads.api.LaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.local.GetLaunchpadProvider
import com.example.launchpadx.navigation.Navigator
import kotlinx.coroutines.launch

class LaunchpadViewModel(
    private val navigator: Navigator,
    private val launchpadProvider: LaunchpadProvider,
    private val getLaunchpadProvider: GetLaunchpadProvider
) : ViewModel() {

    val launchpad = MutableLiveData<Launchpad>()
    val showProgress = MutableLiveData<Boolean>()

    init {
        getLaunchpad()
    }

    private fun getLaunchpad() {
        showProgress.postValue(true)
        viewModelScope.launch {
            loadLaunchpad(getLaunchpadProvider.execute())
        }
    }

    private fun loadLaunchpad(siteId: String) {
        viewModelScope.launch {
            safeExecute<Launchpad> {
                request = {
                    launchpadProvider.execute(siteId)
                }
                error = {
                    showProgress.postValue(false)
                }
                success = {
                    showProgress.postValue(false)
                    launchpad.value = it
                }
            }
        }
    }
}