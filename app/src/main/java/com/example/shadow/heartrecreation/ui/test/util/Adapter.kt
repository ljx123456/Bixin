package com.example.shadow.heartrecreation.ui.test.util

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.ui.UIUtils.setAgeUtils
import com.example.shadow.heartrecreation.ui.image.ImageInfo
import com.example.shadow.heartrecreation.ui.image.utils
import com.example.shadow.heartrecreation.ui.main.adapter.ImageAdapter
import com.example.shadow.heartrecreation.ui.main.adapter.ImageInfoList
import com.example.shadow.heartrecreation.utils.image.ImageLoad
import com.makeramen.roundedimageview.RoundedImageView

class Adapter: BaseQuickAdapter<Person, BaseViewHolder> {

    constructor(list: MutableList<Person>) : super(R.layout.item_serve_list, list)

    override fun convert(helper: BaseViewHolder, item: Person) {
        ImageLoad.setImageNull(item.avatar, helper.getView(R.id.serveImage) as RoundedImageView)
        helper.setText(R.id.brokerName, item.name)
                .setText(R.id.brokerAge, "${item.age}")
                .setVisible(R.id.brokerLayout,false)
//                .setText(R.id.brokerSao, "魅力值:${item.charmValue}")
//                .addOnClickListener(R.id.yue)
//        if (item.km != null && !"null".equals(item.km)) {
//            helper.setText(R.id.brokerAdds, "${item.km}")
//        } else {
//            helper.setText(R.id.brokerAdds, "")
//        }
//        if (item.occupationName != null) {
            helper.setVisible(R.id.brokerJoin, true)
            helper.setText(R.id.brokerJoin, item.occ)
//        } else {
//            helper.setVisible(R.id.brokerJoin, false)
//            helper.setText(R.id.brokerJoin, item.occupationName)
//        }
        var ageView = helper.getView<TextView>(R.id.brokerAge)
        setAgeUtils(ageView, item.sex, "${item.age}")

        var lists = helper.getView(R.id.brokerList) as RecyclerView
        var imageList = ArrayList<ImageInfoList>()
        item.images.forEach { imageList.add(ImageInfoList(it, 2)) }
        var adapters = ImageAdapter(imageList)
        var manager = LinearLayoutManager(mContext)
        manager.orientation = LinearLayout.HORIZONTAL
        lists.layoutManager = manager
        lists.adapter = adapters
        adapters!!.setOnItemClickListener { adapter, view, position ->
            var imagelist = ArrayList<ImageInfo>()
            adapters.data.forEach { imagelist.add(ImageInfo("${it.url}", false, it.imageId)) }
            utils.intentImage(false, imagelist, position)
        }


        var yue = helper.getView(R.id.yue) as TextView




    }

}

