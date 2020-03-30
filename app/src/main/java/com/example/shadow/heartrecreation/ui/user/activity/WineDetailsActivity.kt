package com.example.shadow.heartrecreation.ui.user.activity

import android.view.LayoutInflater
import android.view.View
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user.getUserToken
import com.example.shadow.heartrecreation.place.intentUtils
import com.example.shadow.heartrecreation.ui.main.pop.PopupWindowHelper
import com.example.shadow.heartrecreation.ui.user.adapter.WineDetailsAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BusinessBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.BusinessBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.BusinessPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.BusinessView
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentExpire
import com.example.shadow.heartrecreation.ui.user.utils.intentUtils.intentRecordOne
import kotlinx.android.synthetic.main.activity_wine_details.*
import kotlinx.android.synthetic.main.layout_title.*

class WineDetailsActivity : BaseActivity(), BusinessView {
    override fun getBusinessRequest(data: BusinessBean) {
        detailsName.text = data.data.businessInfo.businessName
        detailsAdds.text = "商家地址："+data.data.businessInfo.businessAddress
        var adapter = WineDetailsAdapter(data.data.wineInfo, mContext)
        detailsList.setGroupIndicator(null)
        detailsList.setAdapter(adapter)
        for (i in data.data.wineInfo.indices) {
            detailsList.expandGroup(i)
        }
        detailsList.setOnGroupClickListener { parent, v, groupPosition, id ->
            return@setOnGroupClickListener true
        }
        Click.viewClick(detailsAdds).subscribe {
            intentUtils.intentPlace("", data.data.businessInfo.longitude, data.data.businessInfo.latitude, data.data.businessInfo.latitude, data.data.businessInfo.longitude, data.data.businessInfo.avatar)
        }
    }

    override fun getBusinessError() {

    }

    override fun openEventBus(): Boolean = false
    private var id = 0
    override fun getActivityLayout(): Int = R.layout.activity_wine_details
    private val presenter by lazy { BusinessPresenter(this, this, this) }
    private lateinit var pop: PopupWindowHelper
    private lateinit var popView: View
    override fun setActivityTitle() {
        titleText.setText("存酒")
        id = intent.getIntExtra("id", 0)
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        titleRight.setImageResource(R.mipmap.nav_button_share_black_nor)
    }

    override fun initActivityData() {
        popView = LayoutInflater.from(mContext).inflate(R.layout.pop_wine, null)
        pop = PopupWindowHelper(popView)
        presenter.getBusiness(BusinessBody(getUserToken(), id))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
        Click.viewClick(titleRight).subscribe { pop.showAsDropDown(titleRight, 0, 0) }



        //存酒记录
        Click.viewClick(popView.findViewById(R.id.wineRecord)).subscribe {
            intentRecordOne(1, id)
            pop.dismiss()
        }
        //取酒记录
        Click.viewClick(popView.findViewById(R.id.wineTake)).subscribe {
            intentRecordOne(2, id)
            pop.dismiss()
        }
        //过期记录
        Click.viewClick(popView.findViewById(R.id.wineOverdue)).subscribe {
            intentExpire(id)
            pop.dismiss()
        }
    }
}