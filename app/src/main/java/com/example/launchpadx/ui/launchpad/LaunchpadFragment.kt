package com.example.launchpadx.ui.launchpad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.launchpadx.R

class LaunchpadFragment : Fragment() {

    companion object {
        fun newInstance() = LaunchpadFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.launchpad_fragment, container, false)
    }
}