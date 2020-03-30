package com.example.shadow.heartrecreation.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class SpaceItemDecoration : RecyclerView.ItemDecoration() {
    private var space = 12
    private var itemSize = 4

    fun setSpace(space: Int) {
        this.space = space
    }

    fun setItemSize(itemSize: Int) {
        this.itemSize = itemSize
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        //不是第一个的格子都设一个左边和底部的间距
        outRect.left = space
        outRect.bottom = space
        //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
        if (parent.getChildLayoutPosition(view) % itemSize == 0) {
            outRect.left = 0
        }
    }


}