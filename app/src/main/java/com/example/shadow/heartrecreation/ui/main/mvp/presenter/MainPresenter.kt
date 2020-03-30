package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.os.Handler
import android.util.Log
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MainBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.TipsBean
import com.example.shadow.heartrecreation.ui.main.mvp.data.MainData
import com.example.shadow.heartrecreation.ui.main.mvp.data.TipsData
import com.example.shadow.heartrecreation.ui.main.mvp.view.MainView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MainPresenter(ower: LifecycleOwner, val view: MainView, val mContext: Context) : BasePresenter(ower, view, mContext), MainData.Main,TipsData.Tips {
    override fun getTipsDataErroe() {

    }

    override fun getTipsDataRequest(data: TipsBean) {
        view.getTipsDataRequest(data)
    }


    private val main = MainData(this)
    private val tips=TipsData(this)

    fun getTipsData(){
        tips.getTipsData()
    }

    fun getMainData() {
        view.showLoading(mContext)
        main.getMainData()
    }

    override fun getMainDataRequest(data: MainBean) {
        view.dismissLoading(mContext)
        view.getMainDataRequest(data)
    }

    override fun getMainDataErroe() {
        var h= Handler()
        h.postDelayed(object :Runnable{
            override fun run() {
                view.dismissLoading(mContext)
                Log.e("点击","dismiss了")
                h.removeCallbacksAndMessages(null)
            }

        },1000)

        view.getMainDataErroe()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        main.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}