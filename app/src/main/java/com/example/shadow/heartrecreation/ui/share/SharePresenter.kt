package com.example.shadow.heartrecreation.ui.share

import android.app.Activity
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseContext.getContext
import com.example.shadow.heartrecreation.base.BasePresenter
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject
import com.tencent.mm.opensdk.openapi.IWXAPI
import com.tencent.mm.opensdk.openapi.WXAPIFactory
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class SharePresenter(owner: LifecycleOwner, val view: ShareView, var mContext: Context) : BasePresenter(owner, view, mContext), ShareDialog.Share {

    private lateinit var api: IWXAPI
    private lateinit var mActivity: Activity
    private var textContext = ""
    private var title=""
    private var url=""
    private var img=""
    private var shareDialog = ShareDialog(this)


    //开始微信分享
    override fun setShareWX() {
        wechatShare(false)
    }

    //开始分享
    fun wechatShare(type: Boolean) {//true 朋友圈
        val api = WXAPIFactory.createWXAPI(getContext(), null)
        api.registerApp("wx4d89639ebf5bc12a")
        var webpage = WXWebpageObject()
        webpage.webpageUrl = url
        var msg = WXMediaMessage(webpage)
        var thumb = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_app)
        if (thumb != null) {
            var mBp = Bitmap.createScaledBitmap(thumb, 120, 120, true)
            thumb.recycle()
            msg.thumbData = Util.bmpToByteArray(mBp, true)
        }
        var req = SendMessageToWX.Req()

//        req.transaction = SendMessageToWX.Req.buildTransaction("webpage")
        if (type) {
            msg.title = textContext
//            msg.description = textContext
            Log.e("测试分享",textContext)
            req.message = msg
            req.transaction ="${System.currentTimeMillis()}"//transaction字段用于唯一标识一个请求，这个必须有，否则会出错
            req.scene = SendMessageToWX.Req.WXSceneTimeline
        }
        else {
            msg.title = title
            msg.description = textContext
            Log.e("测试分享",textContext)
            req.message = msg
            req.transaction ="${System.currentTimeMillis()}"//transaction字段用于唯一标识一个请求，这个必须有，否则会出错
            req.scene = SendMessageToWX.Req.WXSceneSession
        }
        api.sendReq(req)
    }

    //开始朋友圈分享
    override fun setSharePYQ() {
        wechatShare(true)
    }

    //服务人员详情分享
    fun showShareDialogServe(mActivity: Activity, title: String, text: String,url:String,img:String) {
        this.mActivity = mActivity
//        web = UMWeb(webHtml)
        this.title=title
        this.textContext = text
        this.url=url
        this.img=img
        if (shareDialog.isAdded){
            shareDialog.dismiss()
        }else {
            shareDialog.showDialog(mActivity, "")
        }
    }

    //服务人员详情分享
    fun showShareDialogMerchant(mActivity: Activity, title: String, text: String,url:String,img:String) {
        this.mActivity = mActivity
        this.title=title
        this.textContext = text
        this.url=url
        this.img=img
        if (shareDialog.isAdded){
            shareDialog.dismiss()
        }else {
            shareDialog.showDialog(mActivity, "")
        }
    }

    //订单分享
    fun showShareDialogOrder(mActivity: Activity, title: String, text: String,url:String,img:String) {
        this.mActivity = mActivity
        this.title=title
        this.textContext = text
        this.url=url
        this.img=img
        if (shareDialog.isAdded){
            shareDialog.dismiss()
        }else {
            shareDialog.showDialog(mActivity, "")
        }
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {

    }

    override fun presenterDestroy() {

    }
}