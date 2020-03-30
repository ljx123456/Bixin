package com.example.shadow.heartrecreation.ui.main.activity

import android.annotation.SuppressLint
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import com.blankj.utilcode.util.NetworkUtils
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseActivity
import com.example.shadow.heartrecreation.utils.utils.Click
import kotlinx.android.synthetic.main.activity_html.*
import kotlinx.android.synthetic.main.layout_title.*

class BannerActivity:BaseActivity(){
    override fun openEventBus(): Boolean = false

    override fun getActivityLayout(): Int = R.layout.activity_html

    override fun setActivityTitle() {
        titleLeft.setImageResource(R.mipmap.nav_button_back_black_pre)

    }


    @SuppressLint("SetJavaScriptEnabled", "InlinedApi", "NewApi")
    override fun initActivityData() {
        titleText.text=intent.getStringExtra("title")
        if (NetworkUtils.isConnected()) {
            val url = intent.getStringExtra("url")
            html_web.loadUrl(url)
            html_web.setWebViewClient(object : WebViewClient() {
                //覆写shouldOverrideUrlLoading实现内部显示网页
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    html_web.loadUrl(url)
                    return true
                }
            });

            var seting = html_web.settings
            seting.setUseWideViewPort(true);//将图片调整到适合webView的大小
            seting.setLoadWithOverviewMode(true);//缩放至屏幕大小
            seting.cacheMode = WebSettings.LOAD_NO_CACHE
//        seting.setMediaPlaybackRequiresUserGesture(false)//自动播放
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

                override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                    return super.onJsAlert(view, url, message, result)
                }
            })
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
