package com.example.shadow.heartrecreation.ui.meassage.utils

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext
import com.example.shadow.heartrecreation.ui.meassage.activity.ActivitisActivity
import com.example.shadow.heartrecreation.ui.meassage.activity.FeedBackDetailsActivity
import com.example.shadow.heartrecreation.ui.meassage.activity.ReportDetailsActivity

object intentUtils{
    /**
     * 跳转到举报详情
     */
    fun intentReportDetails(id: String) {
        var intent = Intent(BaseContext.getContext(), ReportDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到反馈详情
     */
    fun intentFeedBackDetails(id: String) {
        var intent = Intent(BaseContext.getContext(), FeedBackDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    /**
     * 跳转到活动公告详情
     */
    fun intentActivity(messageId: String,messageType:Int) {
        var intent = Intent(BaseContext.getContext(), ActivitisActivity::class.java)
        intent.putExtra("messageId", messageId)
        intent.putExtra("messageType", messageType)
        ActivityUtils.startActivity(intent)
    }

}