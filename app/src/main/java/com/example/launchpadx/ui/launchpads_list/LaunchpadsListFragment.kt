package com.example.launchpadx.ui.launchpads_list

import android.os.Bundle
import android.widget.Toast
import com.example.launchpadx.R
import com.example.launchpadx.data.entity.LaunchpadsList
import com.example.launchpadx.databinding.LaunchpadsListFragmentBinding
import com.example.launchpadx.ui.base.fragment.BaseBindingFragment
import org.koin.android.ext.android.inject


class LaunchpadsListFragment : BaseBindingFragment<LaunchpadsListFragmentBinding>(R.layout.launchpads_list_fragment) {

    private val listViewModel: LaunchpadsListViewModel by inject()

    override fun bind(binding: LaunchpadsListFragmentBinding) {
        binding.vm = listViewModel
        binding.adapter = LaunchpadAdapter(LaunchpadsList(), listViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        listViewModel.errorMessage.observe(this, {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        })
    }
}