package com.example.launchpadx.ui.launchpad_item

import android.os.Bundle
import android.widget.Toast
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadItemFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaunchpadItemFragment : BaseBindingFragment<LaunchpadItemFragmentBinding>(R.layout.launchpad_item_fragment) {

    private val itemViewModel: LaunchpadItemViewModel by viewModel()

    override fun bind(binding: LaunchpadItemFragmentBinding) {
        binding.vm = itemViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        itemViewModel.errorMessage.observe(this, {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
    }

}