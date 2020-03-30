package com.example.shadow.heartrecreation.ui.main.view

import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean

interface BannerView {
    fun OnClickListener(get: MainBean.DataBean.ShowBean)
}