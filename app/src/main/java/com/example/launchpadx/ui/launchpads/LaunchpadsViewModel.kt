package com.example.launchpadx.ui.launchpads

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.entity.Launchpad
import com.example.launchpadx.data.response.LaunchpadsResponse
import com.example.launchpadx.data.safeExecute
import com.example.launchpadx.domain.interaction.launchpads.AllLaunchpadsProvider
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.GenericFragmentAction
import kotlinx.coroutines.launch
import retrofit2.Response

class LaunchpadsViewModel(
    private val navigator: Navigator,
    private val allLaunchpadsProvider: AllLaunchpadsProvider
) : ViewModel(), LaunchpadListener {

    val launchpads = MutableLiveData<List<Launchpad>>()

    init {
        loadLaunchpads()
    }


    override fun onLaunchpadClick(launchpad: Launchpad) {
        TODO("Not yet implemented")
    }

    fun navigate(destinationId: Int) {
        navigator.execute(GenericFragmentAction(destinationId))
    }

    private fun loadLaunchpads() {
        viewModelScope.launch {
            safeExecute<List<Launchpad>> {
                request = {
                    allLaunchpadsProvider.execute()
                }
                error = {}
                success = {
                    launchpads.value = it
                }
            }
        }
    }
}