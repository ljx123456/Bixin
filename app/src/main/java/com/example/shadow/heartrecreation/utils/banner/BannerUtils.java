package com.example.shadow.heartrecreation.utils.banner;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.shadow.heartrecreation.R;
import com.example.shadow.heartrecreation.ui.image.ImageInfo;
import com.example.shadow.heartrecreation.ui.image.utils;
import com.example.shadow.heartrecreation.utils.image.ImageLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class BannerUtils {

    public  void setBanner(ConvenientBanner banner, ArrayList<ImageInfo> list) {

        banner.setPages(new CBViewHolderCreator() {
            @Override
            public Holder createHolder(View itemView) {
                return new LocalImageHolderView(itemView);
            }

            @Override
            public int getLayoutId() {
                return R.layout.item_image;
            }
        }, list)
                .setPageIndicator(new int[]{R.drawable.gray_circle, R.drawable.white_circle})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_LEFT)
                .startTurning(4000)
                .setOnItemClickListener(new OnItemClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onItemClick(int position) {
                        if (list.get(position).getAddButton()) {

                        } else {
                            List imagelist = new ArrayList<ImageInfo>();
                            list.forEach(new Consumer<ImageInfo>() {
                                @Override
                                public void accept(ImageInfo imageInfo) {
                                    imagelist.add(new ImageInfo(imageInfo.getImageUrl(), imageInfo.getAddButton(), imageInfo.getImageId()));
                                }
                            });
                            utils.INSTANCE.intentImage(false, (ArrayList<ImageInfo>) imagelist, position);
                        }

                    }
                })
                .setCanLoop(true);

    }


    public  class LocalImageHolderView extends Holder<ImageInfo> {
        private ImageView imageView;
        private ImageView textView;

        public LocalImageHolderView(View itemView) {
            super(itemView);
        }


        @Override
        protected void initView(View itemView) {
            imageView = itemView.findViewById(R.id.itemImage);
            textView = itemView.findViewById(R.id.textView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void updateUI(ImageInfo data) {
            //1视频 2图片
            if (data.getAddButton()) {
                textView.setVisibility(View.GONE);
            } else {
                if (data.getImageId() == 1) {
                    textView.setVisibility(View.VISIBLE);
                    ImageLoad.INSTANCE.setImage(data.getImageUrl()+"?vframe/jpg/offset/1", imageView);
                } else {
                    textView.setVisibility(View.GONE);
                    ImageLoad.INSTANCE.setImage(data.getImageUrl(), imageView);
//                    ImageLoad.INSTANCE.setImage(data.getImageUrl()+"?imageView2/1/w/200/h/200/q/75", imageView);
                }
            }


        }
    }

}


