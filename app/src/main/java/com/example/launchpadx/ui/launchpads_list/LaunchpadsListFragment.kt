package com.example.launchpadx.ui.launchpads_list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadsListFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LaunchpadsListFragment : BaseBindingFragment<LaunchpadsListFragmentBinding>(R.layout.launchpads_list_fragment) {

    private val listViewModel: LaunchpadsListViewModel by inject()

    override fun bind(binding: LaunchpadsListFragmentBinding) {
        binding.vm = listViewModel
        binding.adapter = LaunchpadAdapter(emptyList(), listViewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        lifecycleScope.launch {
            listViewModel.snackBar
                .collect { message ->
                    this@LaunchpadsListFragment.view?.rootView?.let { view ->
                        Snackbar.make(view, message.orEmpty(), Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
