package com.example.launchpadx.ui.launchpads_list

import android.os.Bundle
import android.view.View
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadsListFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import com.google.android.material.snackbar.Snackbar
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
        listViewModel.snackbar.observe(viewLifecycleOwner) { text ->
            text?.let {
                this.view?.let { view -> Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show() }
                listViewModel.onSnackbarShown()
            }
        }
    }
}
