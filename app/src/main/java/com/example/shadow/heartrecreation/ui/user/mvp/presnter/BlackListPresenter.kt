package com.example.shadow.heartrecreation.ui.user.mvp.presnter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BlackListBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BlackListBody
import com.example.shadow.heartrecreation.ui.user.mvp.data.BlackListData
import com.example.shadow.heartrecreation.ui.user.mvp.view.BlackListView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class BlackListPresenter(owner: LifecycleOwner, val view: BlackListView, val mContext: Context) :
        BasePresenter(owner, view, mContext), BlackListData.BlackList {
    private val blacklist = BlackListData(this)

    fun getBlackList(body: BlackListBody) {
        blacklist.getBlackList(body)
    }

    //获取列表成功
    override fun getBlackListRequest(data: BlackListBean) {
        view.getBlackListRequest(data)
    }

    //获取列表失败
    override fun getBlackListError() {
        view.getBlackListError()
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {
        blacklist.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}