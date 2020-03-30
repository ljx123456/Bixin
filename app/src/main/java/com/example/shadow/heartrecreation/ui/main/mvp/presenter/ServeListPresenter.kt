package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.ServeListData
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeListView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ServeListPresenter(owner: LifecycleOwner, val view: ServeListView, val mContext: Context) : BasePresenter(owner, view, mContext), ServeListData.ServeList {

    private val servelist = ServeListData(this)

    fun getServeList(body: ServeListBody) {
//        view.showLoading(mContext)
        servelist.getServeList(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        servelist.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    //获取列表成功
    override fun getServeListRequest(data: ServeListBean) {
//        view.dismissLoading(mContext)
        view.getServeListRequest(data)
    }

    //获取列表失败
    override fun getServeListError() {
//        view.dismissLoading(mContext)
        view.getServeListError()
    }
}