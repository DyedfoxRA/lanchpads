package com.example.launchpadx.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.launchpadx.R

class SwipeToDelete(
    val onItemDelete: (Int) -> Unit
) : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.ACTION_STATE_IDLE,
    ItemTouchHelper.LEFT
) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ) = false

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        onItemDelete(viewHolder.bindingAdapterPosition)
    }

    override fun getSwipeDirs(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        return if (viewHolder.itemViewType != R.layout.launchpad_item) {
            ItemTouchHelper.ACTION_STATE_IDLE
        } else {
            super.getSwipeDirs(recyclerView, viewHolder)
        }
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder) = 0.3f

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView: View = viewHolder.itemView

        val p = Paint().also { it.color = Color.GRAY }
        val icon: Bitmap = BitmapFactory.decodeResource(recyclerView.context.resources, android.R.drawable.ic_delete)

        c.drawRect(
            itemView.right.toFloat() + dX,
            itemView.top.toFloat(),
            itemView.right.toFloat(),
            itemView.bottom.toFloat(),
            p
        )

        val iconMarginRight = (dX * -0.1f).coerceAtMost(70f).coerceAtLeast(0f)
        c.drawBitmap(
            icon,
            itemView.right.toFloat() - iconMarginRight - icon.width,
            itemView.top.toFloat() + (itemView.bottom.toFloat() - itemView.top.toFloat() - icon.height) / 2,
            p
        )

        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}
