package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponUserAddBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.CouponUserAddBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.CouponsBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.CouponUserAddData
import com.example.shadow.heartrecreation.ui.main.mvp.data.CouponsData
import com.example.shadow.heartrecreation.ui.main.mvp.view.CouponsView
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class CouponsPresenter(owner: LifecycleOwner, val view: CouponsView, val mContext: Context) : BasePresenter(owner, view, mContext), CouponsData.Coupons, CouponUserAddData.CouponUserAdd {

    private val coupons = CouponsData(this)
    private val couponuseradd = CouponUserAddData(this)

    //获取优惠券
    fun getCoupons(body: CouponsBody) {
        view.showLoading(mContext)
        coupons.getCoupons(body)
    }

    //领取优惠券
    fun getCouponUserAdd(body: CouponUserAddBody) {
        view.showLoading(mContext)
        couponuseradd.getCouponUserAdd(body)
    }

    //获取列表成功
    override fun getCouponsRequest(data: CouponsBean) {
        view.dismissLoading(mContext)
        view.getCouponsRequest(data)
    }

    //获取列表失败
    override fun getCouponsError() {
        view.dismissLoading(mContext)
        view.getCouponsError()
    }

    //领取成功
    override fun getCouponUserAddRequest(data: CouponUserAddBean) {
//        view.dismissLoading(mContext)
        view.getCouponUserAddRequest(data)
    }

    //领取失败
    override fun getCouponUserAddError() {
        view.dismissLoading(mContext)
        view.getCouponUserAddError()
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        coupons.getDisposable()?.let { list.add(it) }
        couponuseradd.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}