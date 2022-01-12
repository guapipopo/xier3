package com.example.android3;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.android3.Recyclerview.Data;
import com.example.android3.Recyclerview.itembean;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder> {
List<itembean> myData;
Context mContext;

    public ViewPagerAdapter(List<itembean> mData,Context context) {
        this.myData=mData;
        this.mContext=context;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewPagerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewPagerHolder(LayoutInflater.from(mContext).inflate((R.layout.item_vp), parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewPagerHolder holder, int position) {
     holder.setData(myData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if(myData!=null){
            return  myData.size();
        }
        return 0;
    }



    public class ViewPagerHolder extends RecyclerView.ViewHolder {
        private ImageView page;
        private TextView intro;
        private int mPosition;

        public ViewPagerHolder(@NonNull View itemView) {
            super(itemView);
            page=itemView.findViewById(R.id.png);
            intro=itemView.findViewById(R.id.text);

        }

        public void setData(itembean itembean,int position) {
            this.mPosition=position;
            page.setImageResource(itembean.id2);
            intro.setText(itembean.name+"的视频动态:");
        }
    }
}
