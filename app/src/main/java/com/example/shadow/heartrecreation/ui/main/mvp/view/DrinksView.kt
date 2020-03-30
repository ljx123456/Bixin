package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.base.BaseView
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean

interface DrinksView:BaseView {
    fun getDrinksRequest(data: DrinksBean)
    fun getDrinksError()
}