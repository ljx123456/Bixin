package com.example.shadow.heartrecreation.ui.main.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.main.mvp.bean.ServeListSearchBean
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class SearchListAdapter(data: MutableList<ServeListSearchBean.DataBean>) : BaseQuickAdapter<ServeListSearchBean.DataBean, BaseViewHolder>(R.layout.item_search_list, data) {
    override fun convert(helper: BaseViewHolder, item: ServeListSearchBean.DataBean) {
        helper.setText(R.id.searchName, item.nickname)
                .setText(R.id.searchAge, "${item.age}")

                .setText(R.id.searchBx,"（ID:${item.bixinId}）")
                .setVisible(R.id.searchLayout,false)
        if (item.occupationName!=null&&item.occupationName!=""){
            helper.setVisible(R.id.searchJoin,true)
                    .setText(R.id.searchJoin, item.occupationName)
        }else{
            helper.setVisible(R.id.searchJoin,false)
        }
//                .setText(R.id.searchAdds, item.km)
//                .setText(R.id.searchType, item.state)
        var age = helper.getView<TextView>(R.id.searchAge)
        setAgeUtils(age,item.sex,item.age.toString())

//        when (item.sex) {
//            1 -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_man), null, null, null)
//            else -> age.setCompoundDrawablesWithIntrinsicBounds(mContext.resources.getDrawable(R.mipmap.content_icon_lady), null, null, null)
//        }
        ImageLoad.setUserHead(item.avatar, helper.getView(R.id.serveImage) as RoundedImageView)

    }
}