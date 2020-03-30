package com.example.shadow.heartrecreation.ui.user.activity

import android.view.View

import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.DbUtils.getUser
import com.example.shadow.heartrecreation.db.user.getUserBirthday
import com.example.shadow.heartrecreation.db.user.getUserImage
import com.example.shadow.heartrecreation.db.user.getUserNick
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentUserEdit
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import kotlinx.android.synthetic.main.activity_user_set.*
import kotlinx.android.synthetic.main.layout_title.*

class UserSetActivtiy : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_user_set

    override fun setActivityTitle() {
        titleText.setText("修改资料")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.visibility = View.GONE
        titleRightText.visibility = View.VISIBLE
        titleRightText.text = "修改"
    }

    override fun initActivityData() {
        ImageLoad.setUserHead(getUserImage(), userImage)
        userName.text = getUserNick()
//        userID.text=getUserID()
        userBirthday.text = getUserBirthday()
        if (getUser().sex.equals("1")) {
            userAge.text = "男"
        } else {
            userAge.text = "女"
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRightText).subscribe { intentUserEdit() }
    }
}