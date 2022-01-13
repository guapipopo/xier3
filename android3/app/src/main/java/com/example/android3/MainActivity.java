package com.example.android3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android3.Recyclerview.Data;
import com.example.android3.Recyclerview.ListViewAdapter;
import com.example.android3.Recyclerview.itembean;
import com.example.android3.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<itembean> mData;

    ListViewAdapter adapter;
    ViewPagerAdapter adapter2;

private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        initData();


    }

    private void initData(){
        mData = new ArrayList<>();
        for (int i=0;i<Data.icon1.length;i++){
            itembean a=new itembean();
            a.id1=Data.icon1[i];
            a.id2=Data.icon2[i];
            a.name="up"+i;
            mData.add(a);
        }

        adapter=new ListViewAdapter(mData);
        mainBinding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainBinding.recyclerView.setLayoutManager(layoutManager);

        adapter2=new ViewPagerAdapter(mData,this);
        mainBinding.viewpager2.setAdapter(adapter2);


        adapter.setOnItemClickListener(new ListViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mainBinding.viewpager2.setCurrentItem(position);
            }
        });

        adapter.setOnLongItemClickListener(new ListViewAdapter.OnlongitemClickListener() {
            @Override
            public void onLongItemClick(int position) {
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("myPosition", mData.get(position));
                intent.putExtra("myPosition2", position);
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
          int num=data.getIntExtra("delete",0);
          Log.e("a", "onActivityResult: "+num );

            CheckBox checkBox = (CheckBox) LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_detail, null).findViewById(R.id.detail_ison);


                 if(checkBox.isChecked()) {

                 }else {
                     mData.remove(num);
                     adapter.notifyDataSetChanged();
                     adapter2.notifyDataSetChanged();
                 }
        }
    }
}