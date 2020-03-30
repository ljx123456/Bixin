package com.example.shadow.heartrecreation.ui.user.activity

import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_safe.*
import kotlinx.android.synthetic.main.layout_title.*

class SafeActivity:BaseActivity() {
    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int =R.layout.activity_safe

    override fun setActivityTitle() {
        titleText.text="安全中心"
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
    }

    override fun initActivityData() {

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe {
            finish()
        }
        Click.viewClick(set_safe_password).subscribe {
            intentUtils.intentChangePWCode()
        }
    }
}