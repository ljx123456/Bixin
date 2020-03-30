package com.example.shadow.heartrecreation.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shadow.heartrecreation.R;
import com.example.shadow.heartrecreation.ui.main.dialog.CouponsDialog;

import java.math.BigDecimal;
import java.util.List;

public class DrinkDetailsAdapters extends BaseAdapter {
private List<CouponsDialog.DrinkMoney> list;
private Context mContext;

public DrinkDetailsAdapters(List<CouponsDialog.DrinkMoney> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        }

@Override
public int getCount() {
        return list.size();
        }

@Override
public Object getItem(int position) {
        return list.get(position);
        }

@Override
public long getItemId(int position) {
        return position;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.item_drink_details, null);
        holder = new ViewHolder();
        holder.name = convertView.findViewById(R.id.drinkName);
        holder.money = convertView.findViewById(R.id.drinkMoney);
        convertView.setTag(holder);
        } else {
        holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(list.get(position).getMoney());
        holder.money.setText("¥:" + new BigDecimal(list.get(position).getName()).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
        return convertView;
        }

class ViewHolder {
    TextView name;
    TextView money;
}
}
