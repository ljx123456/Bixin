package com.example.shadow.heartrecreation.ui.main.mvp.presenter

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.example.shadow.heartrecreation.base.BasePresenter
import com.example.shadow.heartrecreation.ui.main.mvp.bean.AliPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.OrderPayBean
import com.example.shadow.heartrecreation.ui.main.mvp.bean.WeChatBean
import com.example.shadow.heartrecreation.ui.main.mvp.body.PayBody
import com.example.shadow.heartrecreation.ui.main.mvp.data.PayData
import com.example.shadow.heartrecreation.ui.main.mvp.view.PayView
import com.example.shadow.heartrecreation.utils.http.ErrorDrinks
import com.example.shadow.heartrecreation.utils.utils.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class PayPresenter(owner: LifecycleOwner, val view: PayView, val mContext: Context) : BasePresenter(owner, view, mContext), PayData.Pay {


    class Data(var code: Int, var message: String)

    override fun getPayRequest(data: ResponseBody) {
        view.dismissLoading(mContext)
        val da=data.string()
        var wines:ErrorDrinks?=null
        try {
            wines=Gson().fromJson(da,ErrorDrinks::class.java)
        }catch (e:Exception){
            e.printStackTrace()
        }
        if (wines!=null&&wines.code==-3030){
            view.getPayError(wines)
        }else {
            if (parType.equals("1")) {//支付宝
                var Ali = Gson().fromJson(da, AliPayBean::class.java)
                if (Ali.code == 0) view.AliPay(Ali.data)
                else Toast.Tips(Ali.message)
            } else if (parType.equals("2")){
                var WeChat = Gson().fromJson(da, WeChatBean::class.java)
                if (WeChat.code == 0) view.WeChatPay(WeChat.data)
                else Toast.Tips(WeChat.message)
            }else{
                var Order=Gson().fromJson(da,OrderPayBean::class.java)
                if (Order.code==0)view.getOrderRequest(Order)
                else Toast.Tips(Order.message)
            }
        }

    }

    override fun getPayError(drinks: ErrorDrinks?) {
        view.dismissLoading(mContext)
        view.getPayError(drinks)
    }

    private val pay = PayData(this)
    private var parType = ""

    fun getPay(body: PayBody) {
        view.showLoading(mContext)
        parType = body.payType
        pay.getPay(body)
    }

    override fun addDisposableList(list: ArrayList<Disposable>) {
        pay.getDisposable()?.let { list.add(it) }
    }

    override fun presenterDestroy() {

    }
}