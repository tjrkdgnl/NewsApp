package com.hugh.category.presentation.category.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpacingItemDecoration(
    private var spanCount: Int,
    private var space: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildLayoutPosition(view)
        val column = position % spanCount

        outRect.left = space - column * space / spanCount
        outRect.right = (column + 1) * space / spanCount

        if (position < spanCount) {
            outRect.top = space * 2
        }

        outRect.bottom = space * 2
    }
}