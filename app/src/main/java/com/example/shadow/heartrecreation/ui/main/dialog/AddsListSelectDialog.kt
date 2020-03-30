package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.OrderServeUtils
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.ui.main.adapter.AddsListSelectAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.dialog_broker_adds.*

@SuppressLint("ValidFragment")
class AddsListSelectDialog(val addsSelect: AddsListSelect) : BaseDialogFragment() {
    var info = ArrayList<ServeListBean.DataBean.BusinessInfoBean>()
    var data:ServeListBean.DataBean?=null
    fun setAddsData(data:ServeListBean.DataBean) {
        this.info = data.businessInfo as ArrayList<ServeListBean.DataBean.BusinessInfoBean>
        this.data=data
    }


    override fun setLayoutID(): Int = R.layout.dialog_broker_adds

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
        var addsselectadapter = AddsListSelectAdapter(info)
        var manager = LinearLayoutManager(activity)
        brokerAddsList.layoutManager = manager
        brokerAddsList.adapter = addsselectadapter
        var itemDecoration = SpaceItemDecoration()
        itemDecoration.setItemSize(1)
        brokerAddsList.addItemDecoration(itemDecoration)
        addsselectadapter.setOnItemChildClickListener { adapter, view, position ->
            addsselectadapter.data.forEachIndexed { index, businessInfoBean ->
                if (index == position) {
                    businessInfoBean.isCheck = true
                } else {
                    businessInfoBean.isCheck = false
                }
            }
            addsselectadapter.notifyDataSetChanged()

        }
        Click.viewClick(brokerAddsOK).subscribe {
            for (i in addsselectadapter.data.indices){
                var businessInfoBean=addsselectadapter.data[i]
                if (businessInfoBean.isCheck) {
                    DbUtils.setMerchatDB(MerchantDB(0.toLong(),
                            businessInfoBean.businessName,
                            "${businessInfoBean.businessId}", "", "", "","","", false, "", "", "", "", "", ""))
//                    OrderServeUtils.setOrder(OrderServeDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar))
                    ServeUtils.setServe(ServePersonnelDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar,
                            "${data!!.skillPrice}", "", "", "${data!!.age}", "${data!!.sex}", data!!.km, data!!.occupationName))
                    addsSelect.dialog()
                    dismiss()
//                    Toast.Tips("添加成功")
                    break
                }else if (i==addsselectadapter.data.size-1){
                    Toast.Tips("请选择商家")
                }
            }
//            addsselectadapter.data.forEachIndexed { index, businessInfoBean ->
//                if (businessInfoBean.isCheck) {
//                    DbUtils.setMerchatDB(MerchantDB(0.toLong(),
//                            businessInfoBean.businessName,
//                            "${businessInfoBean.businessId}", "", "", "","","", false, "", "", "", "", "", ""))
////                    OrderServeUtils.setOrder(OrderServeDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar))
//                    ServeUtils.setServe(ServePersonnelDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar,
//                            "${data!!.skillPrice}", "", "", "${data!!.age}", "${data!!.sex}", data!!.km, data!!.occupationName))
//                    addsSelect.dialog()
//                    dismiss()
//                    Toast.Tips("添加成功")
//                }else if (index==addsselectadapter.data.size-1){
//                    Toast.Tips("请选择商家")
//                }
//            }

        }
    }


    override fun clickListener() {
    }

    interface AddsListSelect{
        fun dialog()
    }
}