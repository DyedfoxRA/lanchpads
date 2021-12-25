package com.example.launchpadx.ui.launchpads

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.launchpadx.R

class LaunchpadsFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchpadsFragment()
    }

    private lateinit var viewModel: LaunchpadsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.launchpads_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LaunchpadsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}