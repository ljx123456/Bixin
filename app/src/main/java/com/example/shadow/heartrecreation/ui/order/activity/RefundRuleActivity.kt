package com.example.shadow.heartrecreation.ui.order.activity

import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.layout_title.*

class RefundRuleActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_refund_rule
    override fun setActivityTitle() {
        titleText.setText("退款规则")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
    }

    override fun clickListener() {
        Click.viewClick(titleText).subscribe { finish() }
    }
}