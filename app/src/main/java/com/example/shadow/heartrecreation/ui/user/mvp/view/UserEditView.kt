package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.login.mvp.bean.CheckNameBean
import com.example.shadow.heartrecreation.ui.user.mvp.bean.UserEditBean

interface UserEditView : BaseView {
    fun getUserEditRequest(data: UserEditBean)
    fun setCheckNameRequest(data: CheckNameBean)
}