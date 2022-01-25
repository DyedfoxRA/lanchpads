package com.example.launchpadx.ui.launchpad_item

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadItemFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class LaunchpadItemFragment : BaseBindingFragment<LaunchpadItemFragmentBinding>(R.layout.launchpad_item_fragment) {

    private val args: LaunchpadItemFragmentArgs by navArgs()
    private val itemViewModel: LaunchpadItemViewModel by viewModel { parametersOf(args.siteId) }

    override fun bind(binding: LaunchpadItemFragmentBinding) {
        binding.vm = itemViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        lifecycleScope.launch {
            itemViewModel.snackBar
                .collect { message ->
                    this@LaunchpadItemFragment.view?.rootView?.let { view ->
                        Snackbar.make(view, message.orEmpty(), Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
