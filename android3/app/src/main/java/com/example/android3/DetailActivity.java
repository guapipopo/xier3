package com.example.android3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3.Recyclerview.Data;
import com.example.android3.Recyclerview.itembean;
import com.example.android3.databinding.ActivityDetailBinding;
import com.example.android3.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    private int myPosition;
    private ActivityDetailBinding detailBinding;
    private itembean item;
    private boolean myState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailBinding=  DataBindingUtil.setContentView(this,R.layout.activity_detail);

        detailBinding.detailIson.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText( DetailActivity.this, b?"已关注":"已取关", Toast.LENGTH_SHORT).show();
                if(!b){
                    detailBinding.detailFan.setText("粉丝数:99");
                    myState=false;
                    Log.e("a", "onCheckedChanged: false");

                }else {
                    detailBinding.detailFan.setText("粉丝数:100");
                    myState=true;
                }
                Intent intent=new Intent();
                intent.putExtra("delete",myPosition);
                intent.putExtra("delete2",myState);
                setResult(2,intent);



            }
        });




            item = (itembean)getIntent().getSerializableExtra("myPosition");
            myPosition=getIntent().getIntExtra("myPosition2",0);
            if(item!=null){
            detailBinding.detailIcon.setImageResource(item.id1);
            detailBinding.detailPng.setImageResource(item.id2);
            detailBinding.detailName.setText(item.name);}




        detailBinding.detailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }




}