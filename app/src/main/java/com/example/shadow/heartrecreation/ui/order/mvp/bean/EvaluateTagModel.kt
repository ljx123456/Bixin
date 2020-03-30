package com.example.shadow.heartrecreation.ui.order.mvp.bean

data class EvaluateTagModel(val tagId: Int, val tagName: String, var chack: Boolean)
data class EvaluateModel(val name: String, val list: List<EvaluateTagModel>)