package com.example.shadow.heartrecreation.ui.user.activity

import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import kotlinx.android.synthetic.main.layout_title.*

class JinjiActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_refund

    override fun setActivityTitle() {
        titleText.setText("紧急处理")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}