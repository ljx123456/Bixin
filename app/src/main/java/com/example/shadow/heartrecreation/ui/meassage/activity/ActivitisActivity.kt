package com.example.shadow.heartrecreation.ui.meassage.activity

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.db.user
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_html.*
import kotlinx.android.synthetic.main.layout_title.*

class ActivitisActivity:BaseActivity(){
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_html

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)

    }

    private var htmlText = ""
    @SuppressLint("SetJavaScriptEnabled", "InlinedApi", "NewApi")
    override fun initActivityData() {
        var id=intent.getStringExtra("messageId")
        var type = intent.getIntExtra("messageType", 1)
//        外网示例：http://app.bixinyule.com/user/manage/message/?token=1m+iiWM+nr4EPdXjxTKc2CkD3ayF3ktxab8KLwjLvXm89UqRr1WBAZB17vHSCNM=&messageId=1&type=1&port=1
//        本地测试示例：http://192.168.1.222/user/manage/message/?token=1m+iiWM+nr1UonePtxab8KLwjLvXm89EUOrYBiJtb4RCDUqRr1WBAZB17vHSCNM=&messageId=1&type=1&port=1
        htmlText="http://app.bixinyule.com/user/manage/message/?token=${user.getUserToken()}&messageId=${id}&type=${type}&port=1"
        if (NetworkUtils.isConnected()) {
            html_web.loadUrl(htmlText)
            html_web.setWebViewClient(object : WebViewClient() {
                //覆写shouldOverrideUrlLoading实现内部显示网页
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    html_web.loadUrl(htmlText)
                    return true
                }
            });

            var seting = html_web.settings
            seting.setUseWideViewPort(true);//将图片调整到适合webView的大小
            seting.setLoadWithOverviewMode(true);//缩放至屏幕大小
            seting.javaScriptEnabled = true
//            html_web.setWebChromeClient(object : WebChromeClient() {
//                override fun onProgressChanged(view: WebView?, newProgress: Int) {
//                    if (newProgress == 100) {
//                        progressBar1.visibility = View.GONE
//                    } else {
//                        progressBar1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
//                        progressBar1.setProgress(newProgress)
//                    }
//                }
//            })
        }else{
            html_web.visibility= View.GONE
        }

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        html_web.destroy()
    }

    override fun onResume() {
        super.onResume()
        html_web.onResume()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (html_web.canGoBack()) {
                html_web.goBack()
            } else {
                finish()
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}