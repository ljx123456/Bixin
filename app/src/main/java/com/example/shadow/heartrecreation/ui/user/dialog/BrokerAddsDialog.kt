package com.example.shadow.heartrecreation.ui.user.dialog

import android.support.v7.widget.LinearLayoutManager
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.ui.user.adapter.BrokerAddsAdapter
import com.example.shadow.heartrecreation.ui.user.mvp.bean.BrokerBean
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.dialog_broker_adds.*


class BrokerAddsDialog : BaseDialogFragment() {
    override fun setLayoutID(): Int = R.layout.dialog_broker_adds
    private var title = ""
    private var typeID = 1
    private var type = 1
    private var brokerID = ""
    private var image = ""
    private var name = ""
    private var brokerAge = ""
    private var brokerSex = ""
    private var occupationName = ""
    private var addsDatas = ArrayList<BrokerBean.DataBean.BusinessInfoBean>()

    fun setData(title: String, typeID: Int, type: Int, brokerID: String, image: String, name: String, brokerAge: String, brokerSex: String, occupationName: String, addsData: List<BrokerBean.DataBean.BusinessInfoBean>) {
        this.title = title
        this.typeID = typeID
        this.type = type
        this.brokerID = brokerID
        this.image = image
        this.name = name
        this.brokerAge = brokerAge
        this.brokerSex = brokerSex
        this.occupationName = occupationName
        this.addsDatas = addsData as ArrayList<BrokerBean.DataBean.BusinessInfoBean>
    }

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
        var dialogAdapter = BrokerAddsAdapter(addsDatas)
        var manager = LinearLayoutManager(activity)
        brokerAddsList.layoutManager = manager
        brokerAddsList.adapter = dialogAdapter
        var itemDecoration = SpaceItemDecoration()
        itemDecoration.setItemSize(1)
        brokerAddsList.addItemDecoration(itemDecoration)
        dialogAdapter.setOnItemChildClickListener { adapter, view, position ->
            dialogAdapter.data.forEachIndexed { index, businessInfoBean ->
                if (index == position) {
                    businessInfoBean.isCheck = true
                } else {
                    businessInfoBean.isCheck = false
                }
            }
            dialogAdapter.notifyDataSetChanged()
        }

        Click.viewClick(brokerAddsOK).subscribe {
            dialogAdapter.data.forEach {
                if (it.isCheck) {
                    user.setRoomType("0")
                    DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                            it.businessName,
                            "${it.businessId}",
                            "",
                           "",
                            "",
                            "",
                            "",
                            false,
                            "", "",
                            "",
                            "",
                            "",
                            ""))
                    intentUsils.intentYue( type, brokerID,
                            image,
                            name,
                            brokerAge,
                            brokerSex,
                            occupationName,
                            "${it.businessId}",
                            it.businessName)
                    activity!!.finish()
                    dismiss()
                }
            }


        }
    }

    override fun clickListener() {

    }


}