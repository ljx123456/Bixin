package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.ServeListSearchBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.ServeListSearchData
import com.example.shadow.heartrecreation.ui.main.mvp.view.ServeListSearchView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class ServeListSearchPresenter(owner: LifecycleOwner, val view: ServeListSearchView, val mContext: Context) : BasePresenter(owner, view, mContext), ServeListSearchData.ServeListSearch {

    private val servelistsearch = ServeListSearchData(this)

    //搜索成功
    override fun getServeListSearchRequest(data: ServeListSearchBean) {
//        view.dismissLoading(mContext)
        view.getServeListSearchRequest(data)
    }

    //搜索失败
    override fun getServeListSearchError() {
//        view.dismissLoading(mContext)
        view.getServeListSearchError()
    }

    //开始搜索
    fun getServeListSearch(body: ServeListSearchBody) {
//        view.showLoading(mContext)
        servelistsearch.getServeListSearch(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        servelistsearch.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}