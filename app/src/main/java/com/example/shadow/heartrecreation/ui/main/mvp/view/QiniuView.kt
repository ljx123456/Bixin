package com.example.shadow.heartrecreation.ui.main.mvp.view

import com.example.shadow.heartrecreation.base.BaseView

interface QiniuView:BaseView {
    fun sendSucceedImage(fileUrlList: ArrayList<String>)
    fun sendFileErrorImage()
}