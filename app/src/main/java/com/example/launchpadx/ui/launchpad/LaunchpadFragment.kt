package com.example.launchpadx.ui.launchpad

import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadFragmentBinding
import com.example.launchpadx.ui.base.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchpadFragment : BaseBindingFragment<LaunchpadFragmentBinding>(R.layout.launchpad_fragment) {

    companion object {
        fun newInstance() = LaunchpadFragment()
    }

    private val viewModel: LaunchpadViewModel by viewModel()


    override fun bind(binding: LaunchpadFragmentBinding) {
        binding.vm = viewModel
    }

}