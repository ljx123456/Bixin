package com.example.shadow.heartrecreation.ui.user.activity

import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.layoutUtils.getDiscountNull
import com.example.shadow.heartrecreation.ui.layoutUtils.getLayoutNull
import com.example.shadow.heartrecreation.ui.main.mvp.bean.UserFindBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.UserFindBody
import com.example.shadow.heartrecreation.ui.main.mvp.presenter.UserFindPresenter
import com.example.shadow.heartrecreation.ui.main.mvp.view.UserFindView
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils.intentYue
import com.example.shadow.heartrecreation.ui.user.adapter.DiscountAdapter
import kotlinx.android.synthetic.main.activity_discount.*
import kotlinx.android.synthetic.main.layout_error_network.*
import kotlinx.android.synthetic.main.layout_title.*

class DiscountActivity : BaseActivity(), UserFindView {
    override fun getUserFindRequest(data: UserFindBean) {
        dismissLoading()
        refundRefresh.isRefreshing = false
        errorLayout.visibility = View.GONE
        var discontAdatpter = DiscountAdapter(data.data)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        refundList.layoutManager = manager
        refundList.adapter = discontAdatpter
        discontAdatpter.setEmptyView(getDiscountNull())

       discontAdatpter.loadMoreEnd()
//        discontAdatpter.setOnItemClickListener { adapter, view, position ->
//            intentYue(0)
//        }
    }

    override fun getUserFindError() {
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
        refundRefresh.isRefreshing = false
        errorLayout.visibility = View.VISIBLE
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getUserFind(UserFindBody("", token,0.00))
        }
    }

    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_discount
    private val presenter by lazy { UserFindPresenter(this, this, this) }
    private val token = user.getUserToken()

    override fun setActivityTitle() {
        titleText.setText("优惠券")
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)
    }

    override fun initActivityData() {
        showLoading()
        presenter.getUserFind(UserFindBody("", token,0.00))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        refundRefresh.setOnRefreshListener {
            presenter.getUserFind(UserFindBody("", token,0.00))
        }
        Click.viewClick(anewClick).subscribe {
            showLoading()
            presenter.getUserFind(UserFindBody("", token,0.00))
        }
    }
}