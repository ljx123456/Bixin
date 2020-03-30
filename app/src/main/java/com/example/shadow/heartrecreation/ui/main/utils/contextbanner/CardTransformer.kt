package com.example.shadow.heartrecreation.ui.main.utils.contextbanner

import android.support.v4.view.ViewPager
import android.view.View

class CardTransformer : ViewPager.PageTransformer {

    private val MAX_SCALE = 1.1f
    private val MIN_SCALE = 1.0f//0.85f

    override fun transformPage(page: View, position: Float) {
        if (position <= 1) {
            //   1.2f + (1-1)*(1.2-1.0)
            val scaleFactor = MIN_SCALE + (1 - Math.abs(position)) * (MAX_SCALE - MIN_SCALE)
            page.scaleX = scaleFactor  //缩放效果
            if (position > 0) {
                page.translationX = -scaleFactor * 2
            } else if (position < 0) {
                page.translationX = scaleFactor * 2
            }
            page.scaleY = scaleFactor
        } else {
            page.scaleX = MIN_SCALE
            page.scaleY = MIN_SCALE
        }
    }
}