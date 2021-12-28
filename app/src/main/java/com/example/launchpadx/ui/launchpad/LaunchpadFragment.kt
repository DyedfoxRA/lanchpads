package com.example.launchpadx.ui.launchpad

import android.os.Bundle
import android.widget.Toast
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchpadFragment : BaseBindingFragment<LaunchpadFragmentBinding>(R.layout.launchpad_fragment) {

    companion object {
        fun newInstance() = LaunchpadFragment()
    }

    private val viewModel: LaunchpadViewModel by viewModel()

    override fun bind(binding: LaunchpadFragmentBinding) {
        binding.vm = viewModel
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