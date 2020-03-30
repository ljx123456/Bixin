package com.example.shadow.heartrecreation.ui

import android.widget.TextView
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseContext.getContext

object UIUtils {
    fun setAgeUtils(textView: TextView, sex: Int, age: String) {
        textView.text = age
        when (sex) {//1男2女
            1 -> {
                textView.setCompoundDrawablesWithIntrinsicBounds(getContext().resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
                textView.setBackgroundResource(R.drawable.man_shape)
            }
            else -> {
                textView.setCompoundDrawablesWithIntrinsicBounds(getContext().resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
                textView.setBackgroundResource(R.drawable.woman_shape)
            }
        }
    }
}