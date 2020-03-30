package com.example.shadow.heartrecreation.ui.user.utils

import android.Manifest.permission.*
import android.app.Activity
import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.mvp.view.activity.RegardWeActivity
import com.example.shadow.heartrecreation.ui.order.activity.OrderActivity
import com.example.shadow.heartrecreation.ui.user.activity.*
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.example.shadow.heartrecreation.utils.zxing.android.CaptureActivity
import com.tbruyelle.rxpermissions2.RxPermissions

object intentUtils {
    /**
     * 跳转到我的关注
     */
    fun intentAttention() {
        ActivityUtils.startActivity(AttentionActivity::class.java)
    }

    /**
     * 跳转到经纪人
     */
    fun intentBroker() {
        ActivityUtils.startActivity(BrokerActivity::class.java)
    }

    /**
     * 跳转到优惠券
     */
    fun intentDiscount() {
        ActivityUtils.startActivity(DiscountActivity::class.java)
    }

    /**
     * 跳转到紧急处理
     */
    fun intentJinji() {
        ActivityUtils.startActivity(JinjiActivity::class.java)
    }

    /**
     * 跳转到订单
     */
    fun intentOrder() {
        ActivityUtils.startActivity(OrderActivity::class.java)
    }

    /**
     * 跳转到退款
     */
    fun intentRefund() {
        ActivityUtils.startActivity(RefundActivity::class.java)
    }

    /**
     * 跳转到扫一扫
     */
    fun intentSao(activity: Activity) {
        val rxPermissions = RxPermissions(activity)
        rxPermissions.request(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, CAMERA).subscribe { aBoolean ->
            if (aBoolean!!) {
                var intent = Intent(getContext(), CaptureActivity::class.java)
                activity.startActivityForResult(intent, 0)
            }
            else {
                Toast.Tips("请打开相机，内存读取权限")
            }
        }

    }

    /**
     * 跳转到设置
     */
    fun intentSet() {
        ActivityUtils.startActivity(SetActivity::class.java)
    }

    /**
     * 跳转到个人信息设置
     */
    fun intentUserSet() {
        ActivityUtils.startActivity(UserSetActivtiy::class.java)
    }

    /**
     * 跳转到存酒
     */
    fun intentWine() {
        ActivityUtils.startActivity(WineActivity::class.java)
    }

    /**
     * 跳转到退款商家详情
     */
    fun intentRefundMerchant(refundId: Int) {
        var intent = Intent(getContext(), RefundMerchantActivity::class.java)
        intent.putExtra("refundId", refundId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到退款服务人员详情
     */
    fun intentRefundServe(refundId: Int) {
        var intent = Intent(getContext(), RefundServeActivity::class.java)
        intent.putExtra("refundId", refundId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到安全中心
     */
    fun intentSafe() {
        ActivityUtils.startActivity(SafeActivity::class.java)
    }

    /**
     * 跳转到修改密码验证码
     */
    fun intentChangePWCode() {
        ActivityUtils.startActivity(ChangePWCodeActivity::class.java)
    }

    /**
     * 跳转到修改密码密码
     */
    fun intentChangePW() {
        ActivityUtils.startActivity(ChangePWActivity::class.java)
    }

    /**
     * 跳转到黑名单
     */
    fun intentBlack() {
        ActivityUtils.startActivity(BlackListActivity::class.java)
    }

    /**
     * 跳转到存酒详情
     */
    fun intentWineDetails(userStorageWineId: Int) {
        var intent = Intent(getContext(), WineDetailsActivity::class.java)
        intent.putExtra("id", userStorageWineId)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到意见反馈
     */
    fun intentOpinionFeedback() {
        ActivityUtils.startActivity(OpinionFeedbackActivity::class.java)
    }

    /**
     * H5界面
     */
    fun intentHtml(type: Int) {
        var intent = Intent(getContext(), HtmlActivity::class.java)
        intent.putExtra("type", type)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 关于我们
     */
    fun intentRegardWe() {
        ActivityUtils.startActivity(RegardWeActivity::class.java)
    }

    /**
     * 修改资料
     */
    fun intentUserEdit() {
        ActivityUtils.startActivity(UserEditActivity::class.java)
    }

    fun intentDrinksRecord(type: Int) {
        var intent = Intent(getContext(), DrinksRecordActivity::class.java)
        intent.putExtra("type", type)
        ActivityUtils.startActivity(intent)
    }

    fun intentRecordDetailsOne(type: Int, id: Int) {
        var intent = Intent(getContext(), RecordDetailsOneActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    fun intentRecordOne(type: Int, businessId: Int) {
        var intent = Intent(getContext(), RecordOneActivity::class.java)
        intent.putExtra("type", type)
        intent.putExtra("businessId", businessId)
        ActivityUtils.startActivity(intent)
    }

    fun intentExpire(businessId: Int) {
        var intent = Intent(getContext(), ExpireActivity::class.java)
        intent.putExtra("businessId", businessId)
        ActivityUtils.startActivity(intent)
    }

    fun intentRecordDetails(id: Int) {
        var intent = Intent(getContext(), RecordDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }


}