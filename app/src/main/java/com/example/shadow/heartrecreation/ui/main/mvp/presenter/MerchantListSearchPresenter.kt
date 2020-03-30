package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantListSearchBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantListSearchBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.MerchantListSearchData
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantListSearchView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MerchantListSearchPresenter(owner: LifecycleOwner, val view: MerchantListSearchView, val mContext: Context) : BasePresenter(owner, view, mContext), MerchantListSearchData.MerchantListSearch {
    private val merchantlistsearch = MerchantListSearchData(this)

    fun getMerchantListSearch(body: MerchantListSearchBody) {
        merchantlistsearch.getMerchantListSearch(body)
    }

    override fun getMerchantListSearchRequest(data: MerchantListSearchBean) {
        view.getMerchantListSearchRequest(data)
    }

    override fun getMerchantListSearchError() {
        view.getMerchantListSearchError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        merchantlistsearch.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {
    }
}