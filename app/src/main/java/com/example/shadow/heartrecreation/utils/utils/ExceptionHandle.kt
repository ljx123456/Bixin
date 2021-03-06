package cn.camera.com.utils.utils


import com.example.shadow.heartrecreation.utils.http.CodeException
import com.example.shadow.heartrecreation.utils.http.ErrorData
import com.google.gson.JsonParseException

import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException
import javax.net.ssl.SSLHandshakeException


/**
 * Created by Administrator on 2018/2/26 0026.
 */
object ExceptionHandle {


    fun exceptionMessage(e: Throwable): ErrorData {

        return if (e is CodeException) {
            if (e.code==-3030){
                ErrorData(e.code, e.msg,e.data)
            }else {
                ErrorData(e.code, e.msg,null)
            }
        } else if (e is JsonParseException || e is JSONException) {
            ErrorData(0, "解析错误",null)
        } else if (e is ConnectException) {
            ErrorData(0, "连接失败，请重试",null)
        } else if (e is SSLHandshakeException) {
            ErrorData(0, "证书验证失败，请重试",null)
        } else if (e is HttpException) {
            ErrorData(0, "网络异常，请重试",null)
        } else if (e is TimeoutException) {
            ErrorData(0, "网络异常，请重试",null)
        } else if(e is SocketTimeoutException){
            ErrorData(0, "网络异常，请重试",null)
        }else if(e is SocketException){
            ErrorData(0, "网络异常，请重试",null)
        }else if(e is UnknownHostException){
            ErrorData(0, "网络异常，请重试",null)
        } else {
            ErrorData(0, " 未知错误，请重试",null)
        }
    }
}