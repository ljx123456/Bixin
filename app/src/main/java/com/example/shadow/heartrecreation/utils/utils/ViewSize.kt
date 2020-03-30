package com.example.shadow.heartrecreation.utils.utils

import android.view.View
import android.view.ViewGroup
import android.widget.*

object ViewSize {

    fun ViewSize(view: View, width: Int, height: Int) {
        var layoutParams = view.layoutParams
        layoutParams.height = height
        layoutParams.width = width
        view.layoutParams = layoutParams
    }

    fun ViewSize(view: View, width: Int) {
        var layoutParams = view.layoutParams
        layoutParams.width = width
        view.layoutParams = layoutParams
    }

    fun ViewSize(view: View, Width: Int, Height: Int, left: Int, top: Int, right: Int, down: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val layoutParams = view.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.height = Height
            layoutParams.width = Width
            layoutParams.setMargins(left, top, right, down)
            view.layoutParams = layoutParams
        }
    }

    fun ViewSizeFrame(view: View, Width: Int, Height: Int) {
        val params: FrameLayout.LayoutParams
        params = view.layoutParams as FrameLayout.LayoutParams
        params.height = Height
        params.width = Width
        view.layoutParams = params
    }

    fun ViewSizeLinear(view: View, Width: Int, Height: Int) {
        val params: LinearLayout.LayoutParams
        params = view.layoutParams as LinearLayout.LayoutParams
        params.weight = Width.toFloat()
        params.height = Height
        view.layoutParams = params
    }

    fun ViewSizeRelative(view: View, Width: Int, Height: Int) {
        val params: RelativeLayout.LayoutParams
        params = view.layoutParams as RelativeLayout.LayoutParams
        params.width = Width
        params.height = Height
        view.layoutParams = params
    }

    fun ViewSizeAbsolute(view: View, Width: Int, Height: Int) {
        val params: AbsoluteLayout.LayoutParams
        params = view.layoutParams as AbsoluteLayout.LayoutParams
        params.width = Width
        params.height = Height
        view.layoutParams = params
    }

    fun ViewSizeTable(view: View, Width: Int, Height: Int) {
        val params: TableLayout.LayoutParams
        params = view.layoutParams as TableLayout.LayoutParams
        params.width = Width
        params.height = Height
        view.layoutParams = params
    }
}