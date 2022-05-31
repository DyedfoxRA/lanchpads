package com.example.launchpadx.ui.launchpads_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.LaunchpadItemFragmentAction
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.launch

class LaunchpadsListViewModel(
    private val navigator: Navigator,
    launchpadRepository: LaunchpadRepository
) : ViewModel() {

    private val _spinner = MutableStateFlow(false)
    val spinner: StateFlow<Boolean> = _spinner.asStateFlow()

    private val _snackBar = MutableSharedFlow<String?>(replay = 1)
    val snackBar = _snackBar.asSharedFlow()

    private val _launchpads = MutableStateFlow<List<Launchpad>>(emptyList())
    val launchpads = _launchpads.asStateFlow()

    init {
        viewModelScope.launch {
            launchpadRepository.getAllLaunchpads(
                onStart = { _spinner.tryEmit(true) },
                onComplete = { _spinner.tryEmit(false) },
                onError = { _snackBar.tryEmit(it) }
            ).collect {
                _launchpads.value = it
            }
        }
    }

    fun navigate(siteId: String) {
        navigator.execute(LaunchpadItemFragmentAction(siteId))
    }

    fun remoteItem(siteId: String) {
        if (_launchpads.value.size > 1)
            _launchpads.updateAndGet { list -> list.filter { it.siteId != siteId } }
    }
}
