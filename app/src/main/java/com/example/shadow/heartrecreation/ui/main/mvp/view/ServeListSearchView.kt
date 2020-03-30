package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListSearchBean

interface ServeListSearchView:BaseView {
    fun getServeListSearchRequest(data: ServeListSearchBean)
    fun getServeListSearchError()
}