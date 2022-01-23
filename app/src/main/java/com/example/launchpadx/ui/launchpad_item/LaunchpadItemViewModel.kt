package com.example.launchpadx.ui.launchpad_item

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.domain.interaction.launchpads.api.LaunchpadProvider
import com.example.launchpadx.domain.interaction.launchpads.local.GetLaunchpadProvider
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.navigation.Navigator
import kotlinx.coroutines.launch

class LaunchpadItemViewModel(
    private val navigator: Navigator,
    private val launchpadProvider: LaunchpadProvider,
    private val getLaunchpadProvider: GetLaunchpadProvider
) : ViewModel() {

    val launchpad = MutableLiveData<Launchpad>()
    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

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
        viewModelScope.launch {}
    }
}
