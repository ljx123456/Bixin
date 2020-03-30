package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinksBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinksBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.DrinksData
import com.example.shadow.heartrecreation.ui.main.mvp.view.DrinksView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class DrinksPresenter(owner: LifecycleOwner, val view: DrinksView, val mContext: Context) : BasePresenter(owner, view, mContext), DrinksData.Drinks {

    private val drinks = DrinksData(this)

    fun getDrinks(body: DrinksBody) {
//        view.showLoading(mContext)
        drinks.getDrinks(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        drinks.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }

    override fun getDrinksRequest(data: DrinksBean) {
//        view.dismissLoading(mContext)
        view.getDrinksRequest(data)
    }

    override fun getDrinksError() {
//        view.dismissLoading(mContext)
        view.getDrinksError()
    }
}