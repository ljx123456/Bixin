package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OccupationBean

interface OccupationView : BaseView {
    fun getOccupationRequest(data: OccupationBean)

}