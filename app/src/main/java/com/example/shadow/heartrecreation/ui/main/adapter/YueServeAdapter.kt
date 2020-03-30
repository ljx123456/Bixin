package com.example.shadow.heartrecreation.ui.main.adapter

import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.db.db.ServePersonnelDB
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView
import java.math.BigDecimal

class YueServeAdapter(val type:Int,serveData: List<ServePersonnelDB>) : BaseQuickAdapter<ServePersonnelDB, BaseViewHolder>(R.layout.item_yue_serve, serveData) {
    override fun convert(helper: BaseViewHolder, item: ServePersonnelDB) {
        ImageLoad.setUserHead(item.image, helper.getView(R.id.yueServeImage) as RoundedImageView)
        helper.setText(R.id.yueServeName, item.name)
                .setText(R.id.yueServeAdds, "(距离约玩场地约${item.adds}km)")
                .setText(R.id.yueServeMoney, "¥:"+BigDecimal(item.money).setScale(2,BigDecimal.ROUND_HALF_UP).toString())
//                .setText(R.id.yueServeJoin,item.)

        if (item.join!=null&&item.join!=""){
            helper.setVisible(R.id.yueServeJoin,true)
                    .setText(R.id.yueServeJoin,item.join)
        }else{
            helper.setVisible(R.id.yueServeJoin,false)
        }
        var ageView = helper.getView<TextView>(R.id.yueServeAge)
        setAgeUtils(ageView, item.sex.toInt(), "${item.age}")
        if (type==0) {
            helper.setVisible(R.id.yueServeDell,true).addOnClickListener(R.id.yueServeDell)
        }else{
            helper.setVisible(R.id.yueServeDell,false)
        }
    }
}