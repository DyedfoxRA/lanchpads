package com.example.launchpadx.ui.launchpads_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.launchpadx.R
import com.example.launchpadx.data.repo.remote.LaunchpadRepository
import com.example.launchpadx.domain.interaction.launchpads.local.SaveLaunchpadProvider
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.navigation.Navigator
import com.example.launchpadx.navigation.fragment.GenericFragmentAction
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LaunchpadsListViewModel(
    private val navigator: Navigator,
    private val saveLaunchpadProvider: SaveLaunchpadProvider,
    private val launchpadRepository: LaunchpadRepository
) : ViewModel(), LaunchpadListener {

    val launchpads = MutableLiveData<List<Launchpad>>()

    val showProgress = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    private val _spinner = MutableLiveData<Boolean>(false)

    val spinner: LiveData<Boolean>
        get() = _spinner

    private val _snackbar = MutableLiveData<String?>()

    val snackbar: LiveData<String?>
        get() = _snackbar

    private fun aa() {
        viewModelScope.launch {
            launchpadRepository.getAllLaunchpads(
                onStart = { },
                onComplete = { },
                onError = { }
            ).collect {
                launchpads.value = it
            }
        }
    }

    init {
        aa()
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

    fun onSnackbarShown() {
        _snackbar.value = null
    }

    private fun loadLaunchpads() {
//        launchDataLoad { allLaunchpadsProvider.execute() }
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _spinner.value = true
                block()
            } catch (error: Throwable) {
                _snackbar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }
}
