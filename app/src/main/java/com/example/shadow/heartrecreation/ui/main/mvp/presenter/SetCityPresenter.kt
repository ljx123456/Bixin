package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CityListBean
import com.example.shadow.heartrecreation.ui.main.mvp.data.CityListData
import com.example.shadow.heartrecreation.ui.main.mvp.view.SetCityView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class SetCityPresenter(owner: LifecycleOwner, val view: SetCityView, val mContext: Context) : BasePresenter(owner, view, mContext), CityListData.CityList {

    override fun getCityListRequest(data: CityListBean) {
//        view.dismissLoading(mContext)
        view.getCityListRequest(data)
    }

    override fun getCityListError() {
//        view.dismissLoading(mContext)
        view.getCityListError()
    }

    val cityList = CityListData(this)

    fun getCityList() {
//        view.showLoading(mContext)
        cityList.getCityList()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}