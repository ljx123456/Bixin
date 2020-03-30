package com.example.shadow.heartrecreation.ui.user.activity

import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.place.intentUtils
import com.example.shadow.heartrecreation.ui.user.mvp.bean.ExpireRecordInfoBean
import com.example.shadow.heartrecreation.ui.user.mvp.body.ExpireRecordInfoBody
import com.example.shadow.heartrecreation.ui.user.mvp.presnter.ExpireRecordInfoPresenter
import com.example.shadow.heartrecreation.ui.user.mvp.view.ExpireRecordInfoView
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_record_details.*
import kotlinx.android.synthetic.main.layout_title.*

class RecordDetailsActivity : BaseActivity(), ExpireRecordInfoView {
    override fun getExpireRecordInfoRequest(data: ExpireRecordInfoBean) {
        detailsName.text = data.data.businessInfo.businessName
        detailsAdds.text = "商家地址："+data.data.businessInfo.businessAddress
        wineStartTime.text = "存酒时间：${data.data.storageTime}"
        wineEndTime.text = "失效时间：${data.data.expireTime}"
        var detailsAdapter = DetailsAdapter(data.data.wineInfo)
        val manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.VERTICAL
        detailsList.layoutManager = manager
        detailsList.adapter = detailsAdapter
        Click.viewClick(detailsAdds).subscribe { intentUtils.intentPlace("", data.data.businessInfo.longitude, data.data.businessInfo.latitude, data.data.businessInfo.latitude, data.data.businessInfo.longitude, data.data.businessInfo.avatar) }
    }

    override fun getExpireRecordInfoError() {

    }

    override fun openEventBus(): Boolean = false
    private val presenter by lazy { ExpireRecordInfoPresenter(this, this, this) }
    override fun getActivityLayout(): Int = R.layout.activity_record_details
    private var id = 0
    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_nor)
        titleText.text = "过期详情"
    }

    override fun initActivityData() {
        id = intent.getIntExtra("id", 0)
        presenter.getExpireRecordInfo(ExpireRecordInfoBody(id))
    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }
}

class DetailsAdapter(wineInfo: MutableList<ExpireRecordInfoBean.DataBean.WineInfoBean>) : BaseQuickAdapter<ExpireRecordInfoBean.DataBean.WineInfoBean, BaseViewHolder>(R.layout.item_record_list, wineInfo) {
    override fun convert(helper: BaseViewHolder, item: ExpireRecordInfoBean.DataBean.WineInfoBean) {
        helper.setText(R.id.recordListName, item.wineName).setText(R.id.recordListML, "${item.wineSpecifications}/${item.wineUnit}")
                .setText(R.id.recordListNum, "x${item.wineNum}${item.wineUnit}")
    }

}