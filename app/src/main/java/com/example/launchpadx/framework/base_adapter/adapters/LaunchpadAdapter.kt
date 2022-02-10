package com.example.launchpadx.framework.base_adapter.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadItemBinding
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.framework.base_adapter.BaseViewHolder
import com.example.launchpadx.framework.base_adapter.GenericItem
import com.example.launchpadx.framework.base_adapter.Item

class LaunchpadAdapter(
    private val onLaunchpad: (Launchpad) -> Unit
) : GenericItem<LaunchpadItemBinding, Launchpad> {

    override fun isRelativeItem(item: Item): Boolean {
        return item is Launchpad
    }

    override fun getLayoutId(): Int {
        return R.layout.launchpad_item
    }

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): BaseViewHolder<LaunchpadItemBinding, Launchpad> {
        val binding = LaunchpadItemBinding.inflate(layoutInflater, parent, false)
        return LaunchpadViewHolder(binding, onLaunchpad)
    }

    override fun getDiffUtil(): DiffUtil.ItemCallback<Launchpad> = diffUtil

    private val diffUtil = object : DiffUtil.ItemCallback<Launchpad>() {
        override fun areItemsTheSame(oldItem: Launchpad, newItem: Launchpad) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Launchpad, newItem: Launchpad) = oldItem == newItem
    }
}

class LaunchpadViewHolder(
    binding: LaunchpadItemBinding,
    val onLaunchpad: (Launchpad) -> Unit
) : BaseViewHolder<LaunchpadItemBinding, Launchpad>(binding) {

    override fun onBind(item: Launchpad) = with(binding) {
        launchpadCard.setOnClickListener {
            if (bindingAdapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
            onLaunchpad(item)
        }
        launchpadName.text = item.name
    }
}
