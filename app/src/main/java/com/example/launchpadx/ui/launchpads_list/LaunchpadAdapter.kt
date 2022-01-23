package com.example.launchpadx.ui.launchpads_list

import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadItemBinding
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.ui.base.adapter.BaseAdapter

class LaunchpadAdapter(
    list: List<Launchpad>,
    private val launchpadListener: LaunchpadListener
) : BaseAdapter<LaunchpadItemBinding, Launchpad>(list) {

    override val layoutId: Int = R.layout.launchpad_item

    override fun bind(binding: LaunchpadItemBinding, item: Launchpad) {
        binding.apply {
            launchpad = item
            listener = launchpadListener
            executePendingBindings()
        }
    }
}
