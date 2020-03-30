package com.example.shadow.heartrecreation.ui.login.utils

import android.graphics.Color
import android.os.CountDownTimer
import android.widget.TextView
import com.example.shadow.heartrecreation.R


/**
 * Created by Administrator on 2018/8/11 0011.
 * 验证码倒计时
 */
class CodeTime {

    private val startTime: Long = 1000
    private val endTimer = startTime * 60
    private var countDownTimer: CountDownTimer? = null


    fun codeCountTimer(codeView: TextView) {
            countDownTimer = object : CountDownTimer(endTimer, startTime) {
                override fun onFinish() {
                    codeView.isEnabled = true
                    codeView.setTextColor(Color.parseColor("#333333"))
                    codeView.text = "发送验证码"
                }

                override fun onTick(millisUntilFinished: Long) {
                    codeView.isEnabled = false
                    codeView.setTextColor(Color.parseColor("#999999"))
                    codeView.text = "重新获取 "+(millisUntilFinished / 1000).toString()+"s"
                }
            }.start()
    }

    fun onDestroy() {
        if (countDownTimer!=null) {
            countDownTimer?.onFinish()
            countDownTimer?.cancel()
        }
    }
}