package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.FollowChangeBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.MerchantDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.FollowChangeBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.MerchantDetailsBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.FollowChangeData
import com.example.shadow.heartrecreation.ui.main.mvp.data.MerchantDetailsData
import com.example.shadow.heartrecreation.ui.main.mvp.view.MerchantDetailsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MerchantDetailsPresenter(owner: LifecycleOwner, val view: MerchantDetailsView, val mContext: Context) : BasePresenter(owner, view, mContext),
        MerchantDetailsData.MerchantDetails, FollowChangeData.FollowChange {


    override fun getFollowChangeRequest(data: FollowChangeBean) {
        view.dismissLoading(mContext)
        view.getFollowChange()
    }

    override fun getFollowChangeError() {
        view.dismissLoading(mContext)
        view.getFollowChange()
    }

    private val merchantdetails = MerchantDetailsData(this)
    private val followchange = FollowChangeData(this)

    fun getMerchantDetials(body: MerchantDetailsBody) {
//        view.showLoading(mContext)
        merchantdetails.getMerchantDetails(body)
    }

    fun getFollowChange(body: FollowChangeBody) {
        view.showLoading(mContext)
        followchange.getFollowChange(body)
    }


    //获取商家详情成功
    override fun getMerchantDetailsRequest(data: MerchantDetailsBean) {
//        view.dismissLoading(mContext)
        view.getMerchantDetailsRequest(data)
    }

    //获取商家详情失败
    override fun getMerchantDetailsError() {
//        view.dismissLoading(mContext)
        view.getMerchantDetailsError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}