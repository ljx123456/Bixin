package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean

interface ServeListView : BaseView {
    fun getServeListRequest(data: ServeListBean)
    fun getServeListError()
}