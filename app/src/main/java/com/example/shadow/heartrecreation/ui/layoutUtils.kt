package com.example.shadow.heartrecreation.ui

import android.view.LayoutInflater
import android.view.View
import com.example.shadow.heartrecreation.R
import com.example.shadow.heartrecreation.base.BaseContext.getContext

object layoutUtils {

    fun orderLayoutNumm(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_null, null)
    }

    fun getLayoutNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_refund_null, null)
    }

    fun getDiscountNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_discount_null, null)
    }

    fun getSearchNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_search_null, null)
    }

    fun getWineNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_wine_null, null)
    }

    fun getAttentionNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_attention_null, null)
    }
    fun getAttentionKTVNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_attention_ktv_null, null)
    }

    fun getBlackNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_black_null, null)
    }

    fun getNotiNull(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_noti_null, null)
    }

    fun getNoMore(): View {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_no_more, null)
    }
}