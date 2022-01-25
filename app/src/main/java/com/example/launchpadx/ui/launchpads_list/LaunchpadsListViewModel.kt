package com.example.launchpadx.ui.launchpads_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.LaunchpadItemFragmentAction
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class LaunchpadsListViewModel(
    private val navigator: Navigator,
    launchpadRepository: LaunchpadRepository
) : ViewModel(), LaunchpadListener {

    private val _spinner = MutableStateFlow(false)
    val spinner: StateFlow<Boolean> = _spinner.asStateFlow()

    private val _snackBar = MutableSharedFlow<String?>(replay = 1)
    val snackBar = _snackBar.asSharedFlow()

    val launchpads: StateFlow<List<Launchpad>> = launchpadRepository.getAllLaunchpads(
        onStart = { _spinner.tryEmit(true) },
        onComplete = { _spinner.tryEmit(false) },
        onError = { _snackBar.tryEmit(it) }
    ).stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    override fun onLaunchpadClick(launchpad: Launchpad) {
        navigate(launchpad.siteId)
    }

    private fun navigate(siteId: String) {
        navigator.execute(LaunchpadItemFragmentAction(siteId))
    }
}
