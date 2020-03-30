package com.example.shadow.heartrecreation.ui.user.fragment

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseFragment
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.db.user.getlng
import com.example.shadow.heartrecreation.ui.layoutUtils
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.user.adapter.AttertionMerchantAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.AttertionMerchantBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.AttertionMerchantBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.AttertionMerchantPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.AttertionMerchantView
import kotlinx.android.synthetic.main.fragment_attertion_merchant.*
import kotlinx.android.synthetic.main.layout_error_network.*

class AttertionMerchantFragment : BaseFragment(), AttertionMerchantView {

    private val presenter by lazy { AttertionMerchantPresenter(this, this, activity!!) }
    override fun openEventBus(): Boolean = false
    override fun layoutID(): Int = R.layout.fragment_attertion_merchant
    private val token = getUserToken()
    private val lng = getlng()
    private val lat = user.getlat()
    private val pageSize = 10
    private var pageIndex = 1
    private lateinit var merchantAdapter: AttertionMerchantAdapter

    //获取商家成功
    override fun getAttertionMerchantRequest(data: AttertionMerchantBean) {
        try {
            dismiss()
        }catch (e:Exception){
            e.printStackTrace()
        }
        merchantRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        merchantRefresh.visibility=View.VISIBLE
        if (pageIndex == 1) {
            merchantAdapter = AttertionMerchantAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            merchantList.layoutManager = manager
            merchantList.adapter = merchantAdapter
            merchantAdapter.setEmptyView(layoutUtils.getAttentionKTVNull())
        } else {
            merchantAdapter.addData(data.data)
        }
        merchantAdapter.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getAttertionMerchant(AttertionMerchantBody(token, lng, lat, "$pageIndex", "$pageSize"))
            }
        }, merchantList)
//        merchantAdapter.setOnItemClickListener { adapter, view, position ->
//            intentUsils.intentMerchantDetails(merchantAdapter.data[position].businessId.toString(),0)
//        }
//        if (merchantAdapter != null) {
//            merchantAdapter!!.disableLoadMoreIfNotFullPage()
//            merchantAdapter!!.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                merchantAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                merchantAdapter!!.loadMoreComplete()
            }
        }else{
            merchantAdapter!!.loadMoreComplete()
        }

    }

    //获取商家失败
    override fun getAttertionMerchantError() {
        try {
//            dismissLoading(mContext!!)
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismiss()
                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        merchantRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        merchantRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            pageIndex = 1
            show()
            presenter.getAttertionMerchant(AttertionMerchantBody(token, lng, lat, "$pageIndex", "$pageSize"))
        }
    }

    override fun setLayoutTitle() {
    }

    override fun initFragmentData() {
        show()
        presenter.getAttertionMerchant(AttertionMerchantBody(token, lng, lat, "$pageIndex", "$pageSize"))
    }

    override fun setFragmentListener() {
        merchantRefresh.setOnRefreshListener {
            pageIndex = 1
            presenter.getAttertionMerchant(AttertionMerchantBody(token, lng, lat, "$pageIndex", "$pageSize"))
        }
    }


}