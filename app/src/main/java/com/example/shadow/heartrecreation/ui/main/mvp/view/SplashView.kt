package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UpdateBean

/**
 * Created by Administrator on 2018/11/7 0007.
 */
interface SplashView : BaseView {
    fun getUpdateRequest(data: UpdateBean)
    fun getUpdateError(code:Int,message:String)
}