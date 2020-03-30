package com.example.shadow.heartrecreation.ui.order.utils

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.ui.order.activity.*

object intentUtils {
    /**
     * 跳转到订单详情
     */
    fun intentOrderDetils(orderNo: String) {
        var intent = Intent(getContext(), OrderDetailsActivity::class.java)
        intent.putExtra("orderid", orderNo)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到我的邀请
     */
    fun intentMyInvite(orderId: String, s: Int,flag:Boolean) {
        var intent = Intent(getContext(), MyInviteActivity::class.java)
        intent.putExtra("id", orderId)
        intent.putExtra("merchantid", s)
        intent.putExtra("flag",flag)

        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到评价
     */
    fun intentEvaluate(orderNo: String) {
        var intent = Intent(getContext(), EvaluateActivity::class.java)
        intent.putExtra("orderNo", orderNo)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到投诉
     */
    fun intentComplaint(orderNo: String) {
        var intent = Intent(getContext(), ComplaintActivity::class.java)
        intent.putExtra("orderServiceNo", orderNo)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到投诉详情
     */
    fun intentComplaintDetails(complaintId: String) {
        var intent = Intent(getContext(), ComplaintDetailsActivity::class.java)
        intent.putExtra("complaintId", complaintId)
        ActivityUtils.startActivity(intent)
    }

}