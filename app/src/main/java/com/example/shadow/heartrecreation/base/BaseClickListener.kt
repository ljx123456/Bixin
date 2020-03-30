package com.example.shadow.heartrecreation.base

import android.view.View
import com.example.shadow.heartrecreation.utils.utils.FastDoubleClick

/**
 * Created by Administrator on 2018/1/26 0026.
 */
interface BaseClickListener : View.OnClickListener {

    override fun onClick(v: View?) {
        if (!FastDoubleClick.isFastDoubleClick()) viewClick(v!!)
    }

    fun viewClick(v: View)
}