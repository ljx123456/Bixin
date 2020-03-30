package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.DrinkDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.DrinkDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.DrinkDetailsData
import com.example.shadow.heartrecreation.ui.main.mvp.view.DrinkDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class DrinkDetailsPresenter(owner: LifecycleOwner, val view: DrinkDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext), DrinkDetailsData.DrinkDetails {

    fun getDrinkDetails(body: DrinkDetailsBody) {
        view.showLoading(mContext)
        drinkdetails.getDrinkDetails(body)
    }

    override fun getDrinkDetailsRequest(data: DrinkDetailsBean) {
        view.dismissLoading(mContext)
        view.getDrinkDetailsRequest(data)
    }

    override fun getDrinkDetailsError() {
        view.dismissLoading(mContext)
    }

    private val drinkdetails = DrinkDetailsData(this)
    override fun addDisposableList(list: ArrayList<Disposable>) {
        drinkdetails.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}