package com.example.shadow.heartrecreation.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NewRecyclerView extends RecyclerView {

    public NewRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public void onViewRecycled(@NonNull ViewHolder holder) {
//        super.onViewRecycled(holder);
//        ImageView imageView=holder.imageView;
//        if (imageView!=null){
//            Glide.with(context).clear(imageView);
//        }
//    }


}
