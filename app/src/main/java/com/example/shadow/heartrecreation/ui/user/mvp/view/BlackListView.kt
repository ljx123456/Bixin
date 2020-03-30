package com.example.shadow.heartrecreation.ui.user.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BlackListBean

interface BlackListView : BaseView {
    fun getBlackListRequest(data: BlackListBean)
    fun getBlackListError()
}