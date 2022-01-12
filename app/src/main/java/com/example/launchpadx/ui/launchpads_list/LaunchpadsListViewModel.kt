package com.example.launchpadx.ui.launchpads_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.R
import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.entity.LaunchpadsList
import com.example.launchpadx.data.safeExecute
import com.example.launchpadx.domain.interaction.launchpads.api.AllLaunchpadsProvider
import com.example.launchpadx.domain.interaction.launchpads.local.SaveLaunchpadProvider
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.GenericFragmentAction
import kotlinx.coroutines.launch

class LaunchpadsListViewModel(
    private val navigator: Navigator,
    private val allLaunchpadsProvider: AllLaunchpadsProvider,
    private val saveLaunchpadProvider: SaveLaunchpadProvider,
) : ViewModel(), LaunchpadListener {

    val launchpads = MutableLiveData<LaunchpadsList>()
    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    init {
        loadLaunchpads()
    }

    override fun onLaunchpadClick(launchpad: Launchpad) {
        viewModelScope.launch {
            saveLaunchpadProvider.execute(launchpad.siteId)
            navigate()
        }
    }

    fun navigate(destinationId: Int = R.id.action_launchpadsFragment_to_launchpadFragment) {
        navigator.execute(GenericFragmentAction(destinationId))
    }

    private fun loadLaunchpads() {
        showProgress.postValue(true)
        viewModelScope.launch {
            safeExecute<LaunchpadsList> {
                request = {
                    allLaunchpadsProvider.execute()
                }
                error = {
                    showProgress.postValue(false)
                    errorMessage.value = it.message
                }
                success = {
                    showProgress.postValue(true)
                    launchpads.value = it
                }
            }
        }
    }
}
