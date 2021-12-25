package com.example.launchpadx.ui.launchpads

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.launchpadx.R


class LaunchpadsFragment : Fragment(R.layout.launchpads_fragment) {

    companion object {
        fun newInstance() = LaunchpadsFragment()
    }

    private lateinit var viewModel: LaunchpadsViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LaunchpadsViewModel::class.java)
        // TODO: Use the ViewModel
    }
}