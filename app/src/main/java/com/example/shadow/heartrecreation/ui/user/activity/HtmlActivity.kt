package com.example.shadow.heartrecreation.ui.user.activity

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.utils.utils.Click
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_html.*
import kotlinx.android.synthetic.main.layout_title.*

class HtmlActivity : BaseActivity() {
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_html

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)

    }

    private var htmlText = ""
    @SuppressLint("SetJavaScriptEnabled", "InlinedApi", "NewApi")
    override fun initActivityData() {
        var type = intent.getIntExtra("type", 1)
        when (type) {
            1 -> {
                titleText.setText("用户注册使用协议")
                htmlText = yhxy
            }
            2 -> {
                titleText.setText("帮助中心")
                htmlText = bzzz
            }
            3 -> {
                titleText.setText("评分规则")
                htmlText = pfgz
            }
            4 ->{
                titleText.setText("隐私协议")
                htmlText = ysxy
            }
        }
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
            html_web.setWebChromeClient(object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    if (newProgress == 100) {
                        progressBar1.visibility = View.GONE
                    } else {
                        progressBar1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                        progressBar1.setProgress(newProgress)
                    }
                }
            })
        }else{
            html_web.visibility=View.GONE
        }

    }

    override fun clickListener() {
        Click.viewClick(titleLeft).subscribe { finish() }
    }

    var yhxy = "http://app.bixinyule.com/user_help/reg_protocol/"//用户注册协议
    var bzzz = "http://app.bixinyule.com/user_help/"//帮助中心
    var pfgz = "http://api.bixinyule.com/doc/grade.html"//评分规则
    var ysxy="http://app.bixinyule.com/user_help/privacy/"//隐私协议

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