package com.example.launchpadx.ui.launchpad_item

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadItemFragmentBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LaunchpadItemFragment : Fragment(R.layout.launchpad_item_fragment) {

    private val itemViewModel: LaunchpadItemViewModel by viewModel { parametersOf(args.siteId) }
    private val binding by viewBinding(LaunchpadItemFragmentBinding::bind)
    private val args: LaunchpadItemFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        lifecycleScope.launch {
            itemViewModel.snackBar
                .collect { message ->
                    Snackbar.make(binding.root, message.orEmpty(), Snackbar.LENGTH_SHORT).show()
                }
        }
        lifecycleScope.launch {
            with(binding) {
                itemViewModel.launchpad.collect { launchpad ->
                    launchpadName.text = launchpad?.name
                    launchpadStatus.text = launchpad?.status
                    launchpadLocation.text = launchpad?.location?.name
                }
            }
        }
    }
}
