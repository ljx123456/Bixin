package com.example.shadow.heartrecreation.ui.test.util

import android.content.Intent
import com.blankj.utilcode.util.ActivityUtils
import com.example.shadow.heartrecreation.base.BaseContext
import com.example.shadow.heartrecreation.ui.test.activity.MountainActivity
import com.example.shadow.heartrecreation.ui.test.activity.MountaionDetailsActivity
import com.example.shadow.heartrecreation.ui.test.activity.SwimmingActivity
import com.example.shadow.heartrecreation.ui.test.activity.SwimmingDetailsActivity

object intentUtils{
    fun intentSwimming() {
        ActivityUtils.startActivity(SwimmingActivity::class.java)
    }
    fun intentSwimmingDetails(id: Int) {
        var intent = Intent(BaseContext.getContext(), SwimmingDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }

    fun intentMountain() {
        ActivityUtils.startActivity(MountainActivity::class.java)
    }
    fun intentMountainDetails(id: Int) {
        var intent = Intent(BaseContext.getContext(), MountaionDetailsActivity::class.java)
        intent.putExtra("id", id)
        ActivityUtils.startActivity(intent)
    }
}