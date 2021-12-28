package com.example.launchpadx.ui.launchpads

import android.os.Bundle
import android.widget.Toast
import com.example.launchpadx.R
import com.example.launchpadx.data.entity.LaunchpadsList
import com.example.launchpadx.databinding.LaunchpadsFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import org.koin.android.ext.android.inject


class LaunchpadsFragment : BaseBindingFragment<LaunchpadsFragmentBinding>(R.layout.launchpads_fragment) {

    companion object {
        fun newInstance() = LaunchpadsFragment()
    }

    private val viewModel: LaunchpadsViewModel by inject()

    override fun bind(binding: LaunchpadsFragmentBinding) {
        binding.vm = viewModel
        binding.adapter = LaunchpadAdapter(LaunchpadsList(), viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners(){
        viewModel.errorMessage.observe(this, {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
    }
}