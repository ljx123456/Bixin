package com.example.shadow.heartrecreation.ui.leadpage.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.View
import android.view.animation.AlphaAnimation
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.SharedUtils
import com.example.shadow.heartrecreation.ui.leadpage.utils.intentUtils
import com.example.shadow.heartrecreation.ui.main.base.BaseActivity
import com.example.shadow.heartrecreation.ui.main.utils.intentUsils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.utils.utils.Toast
import kotlinx.android.synthetic.main.activity_lead.*

class Lead7Activity: BaseActivity(){
    override fun openEventBus(): Boolean =false

    override fun getActivityLayout(): Int = R.layout.activity_lead

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        image_lead.setImageResource(R.mipmap.lead_default_7)
        image_lead2.setImageResource(R.mipmap.lead_7)
        var h= Handler()
        h.postDelayed(object :Runnable{
            override fun run() {
                var an= AlphaAnimation(0.5f,1.0f)
                an.duration=750
                image_lead2.startAnimation(an)
                image_lead2.visibility= View.VISIBLE
                tv_skip.visibility=View.VISIBLE
                h.removeCallbacksAndMessages(null)
            }
        },750)

    }

    override fun clickListener() {
        Click.viewClick(image_lead2).subscribe {
            intentUtils.intentLead8()
            finish()
        }

        Click.viewClick(tv_skip).subscribe {
            intentUsils.intentMain()
            SharedUtils.saveTag(this)
//            Toast.makeText(this,"已完成新手引导，快去约玩吧~",Toast.LENGTH_LONG)
            Toast.LongTips("已完成新手引导，快去约玩吧~")
            finish()
        }
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView = window.decorView
            val option = ( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            decorView.systemUiVisibility = option
            window.navigationBarColor = Color.TRANSPARENT
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if(KeyEvent.KEYCODE_BACK==keyCode)
            return false
        return super.onKeyDown(keyCode, event)
    }
}