package com.example.launchpadx.ui.launchpads_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.launchpadx.R
import com.example.launchpadx.databinding.LaunchpadsListFragmentBinding
import com.example.launchpadx.domain.model.Launchpad
import com.example.launchpadx.framework.base_adapter.GenericAdapter
import com.example.launchpadx.framework.base_adapter.adapters.LaunchpadAdapter
import com.example.launchpadx.framework.base_adapter.animations.AddableItemAnimator
import com.example.launchpadx.framework.base_adapter.animations.custom.SimpleCommonAnimator
import com.example.launchpadx.framework.base_adapter.animations.custom.SlideInLeftCommonAnimator
import com.example.launchpadx.framework.base_adapter.decoration.FeedDividerItemDecoration
import com.example.launchpadx.framework.base_adapter.decoration.PostDividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LaunchpadsListFragment : Fragment(R.layout.launchpads_list_fragment) {

    private val listViewModel: LaunchpadsListViewModel by inject()
    private val binding by viewBinding(LaunchpadsListFragmentBinding::bind)
    private val adapter: GenericAdapter = GenericAdapter(
        listOf(LaunchpadAdapter(::onLaunchpadClick))
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@LaunchpadsListFragment.adapter

            addItemDecoration(FeedDividerItemDecoration(70))
            addItemDecoration(PostDividerItemDecoration(R.layout.launchpad_item, 10, 0))

            itemAnimator = AddableItemAnimator(SimpleCommonAnimator()).also { animator ->
                animator.addViewTypeAnimation(R.layout.launchpad_item, SlideInLeftCommonAnimator())
                animator.addDuration = 500L
                animator.removeDuration = 500L
            }
        }
    }

    private fun initListeners() {
        lifecycleScope.launch {
            with(binding) {
                listViewModel.snackBar
                    .collect { message ->
                        Snackbar.make(root, message.orEmpty(), Snackbar.LENGTH_SHORT).show()
                    }
            }
        }
        lifecycleScope.launch {
            with(binding) {
                listViewModel.spinner.collect {
                    if (it)
                        progressBar.visibility = View.VISIBLE
                    else
                        progressBar.visibility = View.GONE
                }
            }
        }
        lifecycleScope.launch {
            listViewModel.launchpads.collect {
                adapter.submitList(it)
            }
        }
    }

    private fun onLaunchpadClick(launchpad: Launchpad) {
        listViewModel.navigate(launchpad.siteId)
    }
}
