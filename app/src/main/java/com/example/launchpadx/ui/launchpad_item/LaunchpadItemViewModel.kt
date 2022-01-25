package com.example.launchpadx.ui.launchpad_item

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.navigation.Navigator
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class LaunchpadItemViewModel(
    siteId: String,
    private val navigator: Navigator,
    launchpadRepository: LaunchpadRepository
) : ViewModel() {

    private val _spinner = MutableStateFlow(false)
    val spinner: StateFlow<Boolean> = _spinner.asStateFlow()

    private val _snackBar = MutableSharedFlow<String?>(replay = 1)
    val snackBar = _snackBar.asSharedFlow()

    val launchpad: StateFlow<Launchpad?> = launchpadRepository.getLaunchpad(
        siteId = siteId,
        onStart = { _spinner.tryEmit(true) },
        onComplete = { _spinner.tryEmit(false) },
        onError = { _snackBar.tryEmit(it) }
    ).stateIn(viewModelScope, SharingStarted.Lazily, null)
}
