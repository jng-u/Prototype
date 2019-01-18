package com.example.jngu.prototype;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExpandableComponentListAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static class mViewHolder extends RecyclerView.ViewHolder {
        TextView componentName;
        ProgressBar componentAmonunt;

        mViewHolder(View view) {
            super(view);
            componentName = view.findViewById(R.id.list_component_name);
            componentAmonunt = view.findViewById(R.id.list_component_amount);
        }
    }

    public static class Item {
        public String name;
        float amount;

        Item(String name, float amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    private List<Item> data;
    private int size;

    public ExpandableComponentListAdaptor (List<Item> data) {
        this.data = data;
        size = 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
//        Context context = parent.getContext();
//        float dp = context.getResources().getDisplayMetrics().density;
//        int subItemPaddingLeft = (int) (18 * dp);
//        int subItemPaddingTopAndBottom = (int) (5 * dp);
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_component, parent, false);
        mViewHolder childVH = new mViewHolder(view);
        return childVH;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = data.get(position);
        mViewHolder itemController = (mViewHolder) holder;
        itemController.componentName.setText(item.name);
        itemController.componentAmonunt.setProgress((int)item.amount);
    }

    @Override
    public int getItemCount() {
        return size;
    }

    public void expand(){
        size = data.size();
        notifyItemRangeInserted(0, size);
    }

    public void close(){
        size = 0;
        notifyItemRangeRemoved(0, data.size());
    }

}
