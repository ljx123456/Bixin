package com.example.shadow.heartrecreation.utils.http


import cn.camera.com.utils.utils.ExceptionHandle
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.CacheUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.example.shadow.heartrecreation.db.*
import com.example.shadow.heartrecreation.db.DbUtils.DelUser
import com.example.shadow.heartrecreation.ui.login.utils.intentUtils.intentLogin
import com.example.shadow.heartrecreation.ui.main.dialog.VersionUpdatingDialog
import com.example.shadow.heartrecreation.utils.dialog.ShowDialog
import com.example.shadow.heartrecreation.utils.utils.Toast
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/12/18 0018.
 */
open abstract class BaseData<T> : Observer<T> {

    private var what = 0
    private val saveInfo by lazy { requestCache() }

    private var disposable: Disposable? = null
    private var observable: Observable<T>? = null


    open fun api(able: Observable<T>): BaseData<T> {
        observable = able
        return this
    }

    open fun setMsg(msg: Int): BaseData<T> {
        what = msg
        return this
    }

    open fun build(): BaseData<T> {
        observable?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(this)
        return this
    }


    open fun getDisposable(): Disposable? {
        return if (disposable != null) disposable!! else null
    }


    //请求成功
    override fun onNext(data: T) {
//        LogUtils.a("测试啊baseData成功what:"+what)
//        LogUtils.a("测试啊baseData成功data:"+data.toString())
        onSucceedRequest(data, what)
    }


    //请求失败
    override fun onError(t: Throwable) {
//        LogUtils.a("测试啊baseData失败")
        LogUtils.a(t.toString())
        if (saveInfo.requestDataCache) getSaveData(t) else setErrorRequest(t)
    }


    override fun onSubscribe(d: Disposable) {
        this.disposable = d
    }


    private fun getSaveData(t: Throwable) {
//        LogUtils.a("测试啊baseData数据")
        val resultBean = CacheUtils.getInstance().getSerializable(saveInfo.requestDataCacheTag) as T
        if (resultBean != null) onSucceedRequest(resultBean, what) else setErrorRequest(t)
    }

    private fun setErrorRequest(t: Throwable) {
        val errorData = ExceptionHandle.exceptionMessage(t)
        when (errorData.code) {
            -1104 -> {
                Toast.Tips("登陆信息过期,请重新登录")

//                DelUser()
                DbUtils.DelUser()
                DbUtils.delMerchat()
                DrinkUtils.deleteALLDrinks()
                ServeUtils.deleteALLServe()
                OrderServeUtils.deleteAllOrder()
//                    JMessageClient.logout()
                user.setNum("0")
                user.setOrderNo("")
                user.setType("1")
                user.setRoomType("0")
                user.setBrokerType("0")
                user.setYueID("1")
                user.setYueName("")
                user.setOrderID("")
                user.setCityID("1")
                user.setCity("")
                user.setRoomMoney("0.00")
//                ActivityUtils.finishAllActivities()
                intentLogin()
            }
            -3 -> {

                Toast.Tips("登陆信息过期,请重新登录")
                DbUtils.DelUser()
                DbUtils.delMerchat()
                DrinkUtils.deleteALLDrinks()
                ServeUtils.deleteALLServe()
                OrderServeUtils.deleteAllOrder()
//                    JMessageClient.logout()
                user.setNum("0")
                user.setOrderNo("")
                user.setType("1")
                user.setRoomType("0")
                user.setBrokerType("0")
                user.setYueID("1")
                user.setYueName("")
                user.setOrderID("")
                user.setCityID("1")
                user.setCity("")
                user.setRoomMoney("0.00")
//                DelUser()
//                ActivityUtils.finishAllActivities()
                intentLogin()
            }
            -2 -> {
                Toast.Tips("登陆信息过期,请重新登录")
                DbUtils.DelUser()
                DbUtils.delMerchat()
                DrinkUtils.deleteALLDrinks()
                ServeUtils.deleteALLServe()
                OrderServeUtils.deleteAllOrder()
//                    JMessageClient.logout()
                user.setNum("0")
                user.setOrderNo("")
                user.setType("1")
                user.setRoomType("0")
                user.setBrokerType("0")
                user.setYueID("1")
                user.setYueName("")
                user.setOrderID("")
                user.setCityID("1")
                user.setCity("")
                user.setRoomMoney("0.00")
//                DelUser()
//                ActivityUtils.finishAllActivities()
                intentLogin()
            }
            -9999 ->{
//                Toast.Tips("服务繁忙,请稍后重试")
                onErrorRequest(errorData.code, "服务繁忙,请稍后重试", what,errorData.data)
            }
            -8889 ->{
//                Toast.Tips("网络异常,请重试")
                onErrorRequest(errorData.code, "网络异常,请重试", what,errorData.data)
            }
            -4->{
//                Toast.Tips("服务繁忙,请稍后重试")
                onErrorRequest(errorData.code, "服务繁忙,请稍后重试", what,errorData.data)
            }
            -1 -> {
//                Toast.Tips()
                onErrorRequest(errorData.code, "数据异常，请重新选择后提交", what,errorData.data)
            }
//            -1 -> {
//                Toast.Tips("数据异常，请重新选择后提交")
//            }
            -3030->{
                onErrorRequest(errorData.code, errorData.message, what,errorData.data)
            }
            else -> {
                onErrorRequest(errorData.code, errorData.message, what,errorData.data)
            }
        }

    }


    override fun onComplete() {}

    protected abstract fun requestCache(): SaveInfo

    protected abstract fun onSucceedRequest(data: T, what: Int)

    protected abstract fun onErrorRequest(flag: Int, msg: String, what: Int,data: ErrorDrinks?)

//    protected abstract fun onErrorDrinkRequest(flag: Int, msg: String, what: Int,data: ErrorDrinks)

}