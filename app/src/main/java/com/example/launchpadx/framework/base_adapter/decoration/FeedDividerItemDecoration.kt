package com.example.launchpadx.framework.base_adapter.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FeedDividerItemDecoration(
    private val divider: Int
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val oneSideHorizontalDivider = divider / 2

        with(outRect) {
            left = oneSideHorizontalDivider
            right = oneSideHorizontalDivider
        }
    }
}
