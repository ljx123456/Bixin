package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean

interface UserFindView :BaseView{
    fun getUserFindRequest(data: UserFindBean)
    fun getUserFindError()
}