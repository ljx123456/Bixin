package com.example.shadow.heartrecreation.ui.main.dialog

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseDialogFragment
import com.example.shadow.heartrecreation.db.DbUtils
import com.example.shadow.heartrecreation.db.OrderServeUtils
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.MerchantDB
import com.example.shadow.heartrecreation.db.db.OrderServeDB
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.ui.main.adapter.AddsSelectAdapter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeDetailsBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListBean
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.view.SpaceItemDecoration
import kotlinx.android.synthetic.main.dialog_broker_adds.*

@SuppressLint("ValidFragment")
class AddsSelectDialog(val addsSelect: AddsSelect) : BaseDialogFragment() {
    var info = ArrayList<ServeDetailsBean.DataBean.BusinessInfoBean>()
    var data: ServeDetailsBean.DataBean?=null
    fun setAddsData(data: ServeDetailsBean.DataBean) {
        this.info = data.businessInfo as ArrayList<ServeDetailsBean.DataBean.BusinessInfoBean>
        this.data=data
    }


    override fun setLayoutID(): Int = R.layout.dialog_broker_adds

    override fun isFullScreen(): Boolean = false

    override fun setLayoutData() {
        var addsselectadapter = AddsSelectAdapter(info)
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
                            "${businessInfoBean.businessId}", "", "", "", "","",false, "", "", "", "", "", ""))
//                    OrderServeUtils.setOrder(OrderServeDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar))
                    ServeUtils.setServe(ServePersonnelDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar,
                            "${data!!.skillTypeList.skillTypePriceUp}", "", "", "${data!!.age}", "${data!!.sex}", data!!.km, data!!.occupationName))
                    addsSelect.dialog()
                    dismiss()
//                    Toast.Tips("添加成功")
//                    Log.e("测试选择的的商家","商家i="+i.toString())
                    break
                }else if (i==addsselectadapter.data.size-1){
//                    Log.e("测试选择商家","商家i="+i.toString())
                    Toast.Tips("请选择商家")
                }
            }
//            addsselectadapter.data.forEachIndexed { index, businessInfoBean ->
//                if (businessInfoBean.isCheck) {
//                    DbUtils.setMerchatDB(MerchantDB(0.toLong(),
//                            businessInfoBean.businessName,
//                            "${businessInfoBean.businessId}", "", "", "", "","",false, "", "", "", "", "", ""))
////                    OrderServeUtils.setOrder(OrderServeDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar))
//                    ServeUtils.setServe(ServePersonnelDB(null, "${data!!.userId}", data!!.nickname, data!!.avatar,
//                            "${data!!.skillTypeList.skillTypePriceUp}", "", "", "${data!!.age}", "${data!!.sex}", data!!.km, data!!.occupationName))
//                    addsSelect.dialog()
//                    dismiss()
//                    Toast.Tips("添加成功")
//                    return@forEachIndexed
//                }else if (index==addsselectadapter.data.size-1){
//                    Toast.Tips("请选择商家")
//                }
//            }

        }
    }

    override fun clickListener() {
    }

    interface AddsSelect{
        fun dialog()
    }
}