package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.KTVBoxBean


interface KTVBoxView: BaseView {
    fun getKTVBoxRequest(data: KTVBoxBean)
}