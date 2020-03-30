package com.example.shadow.heartrecreation.ui.main.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.main.adapter.CouponsAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponUserAddBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.CouponsBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.CouponUserAddBody
import com.example.shadow.heartrecreation.ui.main.mvp.body.CouponsBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.CouponsPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.CouponsView
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_coupons.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class CouponsActivity : BaseActivity(), CouponsView {


    //获取成功
    override fun getCouponsRequest(data: CouponsBean) {
        couponsRefresh.isRefreshing = false
//        var adapters = CouponsAdapter(data.data)
//        var manager = LinearLayoutManager(mContext)
//        manager.orientation = LinearLayout.VERTICAL
//        couponsList.layoutManager = manager
//        couponsList.adapter = adapters
//        adapters.setOnItemChildClickListener { adapter, view, position ->
//            when (view.id) {
//                R.id.couponsNext -> {
//                    when (adapters.data.get(position).isIsReceived) {//获取优惠券
//                        false -> {
//                            presenter.getCouponUserAdd(CouponUserAddBody("${adapters.data.get(position).couponId}", getUserToken()))
//                        }
//                    }
//                }
//            }
//        }
    }

    //领取优惠券成功
    override fun getCouponUserAddRequest(data: CouponUserAddBean) {
        Toast.Tips("优惠券领取成功")
        getData()
    }

    //领取优惠券失败
    override fun getCouponUserAddError() {
        getData()
    }

    //获取失败
    override fun getCouponsError() {
        couponsRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        Click.viewClick(anewClick).subscribe { getData() }
    }

    override fun openEventBus(): Boolean = false
    private var businessId = ""
    private val presenter by lazy { CouponsPresenter(this, this, this) }

    override fun getActivityLayout(): Int = R.layout.activity_coupons

    override fun setActivityTitle() {
        titleText.setText("领取优惠券")
        titleLeft.setImageResource(R.mipmap.nav_button_back_white_nor)
    }

    override fun initActivityData() {
        businessId = intent.getStringExtra("businessId")
        if (NetworkUtils.isConnected()) {
            getData()
        }
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        couponsRefresh.setOnRefreshListener {
            getData()
        }
    }

    fun getData() {
        presenter.getCoupons(CouponsBody(businessId, getUserToken()))
    }
}