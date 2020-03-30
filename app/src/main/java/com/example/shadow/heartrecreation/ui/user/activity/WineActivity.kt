package com.example.shadow.heartrecreation.ui.user.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.ui.layoutUtils.getWineNull
import com.example.shadow.heartrecreation.ui.main.pop.PopupWindowHelper
import com.example.shadow.heartrecreation.ui.user.adapter.WineAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.WineBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.WineBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.WinePresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.WineView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentDrinksRecord
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentWineDetails
import kotlinx.android.synthetic.main.activity_wine.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class WineActivity : BaseActivity(), WineView {
    override fun getWineRequest(data: WineBean) {
        dismissLoading()
        wineRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        wineRefresh.visibility=View.VISIBLE
        if (pageIndex==1) {
            wineAdapter = WineAdapter(data.data)
            var manager = LinearLayoutManager(mContext)
            manager.orientation = LinearLayout.VERTICAL
            wineList.layoutManager = manager
            wineList.adapter = wineAdapter
            wineAdapter.setEmptyView(getWineNull())
        }else{
            wineAdapter.addData(data.data)
        }


        wineAdapter.setOnItemClickListener { adapter, view, position ->
            intentWineDetails(wineAdapter.data.get(position).businessId)
        }

        wineAdapter!!.setOnLoadMoreListener(object : BaseQuickAdapter.RequestLoadMoreListener {
            override fun onLoadMoreRequested() {
                pageIndex = pageIndex + 1
                presenter.getWine(pageIndex)
            }
        }, wineList)

//        if (wineAdapter != null) {
//            wineAdapter!!.disableLoadMoreIfNotFullPage()
//            wineAdapter!!.setPreLoadNumber(2)
//        }
        if (data.data.size<10){
            if (pageIndex>1||data.data.size>0){
                wineAdapter!!.loadMoreEnd()
//                notiAdapter.addFooterView(layoutUtils.getNoMore())
            }else{
                wineAdapter!!.loadMoreComplete()
            }
        }else{
            wineAdapter!!.loadMoreComplete()
        }
    }

    override fun getWineError() {
        try {
            var h= Handler()
            h.postDelayed(object :Runnable{
                override fun run() {
                    dismissLoading()
//                    Log.e("点击","dismiss了")
                    h.removeCallbacksAndMessages(null)
                }

            },1000)
        }catch (e:Exception){
            e.printStackTrace()
        }
        wineRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        wineRefresh.visibility=View.GONE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getWine(pageIndex) }
    }

    override fun openEventBus(): Boolean = false
    private lateinit var wineAdapter: WineAdapter
    private val presenter by lazy { WinePresenter(this, this, this) }
    private lateinit var pop: PopupWindowHelper
    private lateinit var popView: View
    private var pageIndex = 1
    override fun getActivityLayout(): Int = R.layout.activity_wine

    override fun setActivityTitle() {
        titleText.setText("存酒KTV")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
        titleRight.setImageResource(R.mipmap.nav_button_share_black_nor)
    }

    override fun initActivityData() {
        showLoading()
        presenter.getWine(pageIndex)
        popView = LayoutInflater.from(mContext).inflate(R.layout.pop_wine, null)
        pop = PopupWindowHelper(popView)
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        wineRefresh.setOnRefreshListener {
            pageIndex=1
            presenter.getWine(pageIndex)
        }
        Click.viewClick(titleRight).subscribe {
            pop.showAsDropDown(titleRight, 0, 0)
        }
        //存酒记录
        Click.viewClick(popView.findViewById(R.id.wineRecord)).subscribe {
            intentDrinksRecord(1)
            pop.dismiss()
        }
        //取酒记录
        Click.viewClick(popView.findViewById(R.id.wineTake)).subscribe {
            intentDrinksRecord(2)
            pop.dismiss()
        }
        //过期记录
        Click.viewClick(popView.findViewById(R.id.wineOverdue)).subscribe {
            intentDrinksRecord(3)
            pop.dismiss()
        }

    }
}