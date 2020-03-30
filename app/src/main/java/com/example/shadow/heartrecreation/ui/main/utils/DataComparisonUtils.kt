package com.example.shadow.heartrecreation.ui.main.utils

import android.widget.TextView
import com.example.shadow.heartrecreation.db.GreenDaoHelper
import com.example.shadow.heartrecreation.db.ServeUtils
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import kotlinx.android.synthetic.main.activity_screen_details.*

object DataComparisonUtils {

    fun ServeData(serveModel: ServePersonnelDB, textView: TextView) {
        var serveDB = GreenDaoHelper.getDaoSessions().servePersonnelDBDao
        var data = ServeUtils.getServeData()
        if (data != null && data.size >= 1 && data.get(0).name != null) {
            if (ServeUtils.haveData(data, serveModel)) {
                textView.text = "已邀约"
                textView.isEnabled = false
            } else {
                textView.isEnabled = true
            }
        } else {
            textView.isEnabled = true
        }
    }

}