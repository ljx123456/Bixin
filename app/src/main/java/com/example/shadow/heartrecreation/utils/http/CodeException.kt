package com.example.shadow.heartrecreation.utils.http

import java.io.IOException

/**
 * Created by Administrator on 2018/5/23 0023.
 */

data class CodeException( var code: Int,  var msg: String,var data:ErrorDrinks?) : IOException()





