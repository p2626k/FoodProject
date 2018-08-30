package com.example.catherine.foodproject;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import android.support.v4.app.FragmentManager;

import com.bumptech.glide.Glide;

import java.util.List;


public class DetialActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvAddress;
    private ImageView ivMenu;
    private final static String TAB ="DetialActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detial_fragment);
        findViews();
        showResults();

    }
    //初始化元件
    public void findViews(){
        tvName = (TextView)findViewById(R.id.tvName);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        ivMenu = (ImageView)findViewById(R.id.ivMenu);
    }
    //接收餐廳資訊，於頁面上顯示店名、地址、Menu
    private void showResults(){
        Log.d(TAB,"step1");
        Bundle bundle = getIntent().getExtras();
        Member member = (Member)bundle.getSerializable("member");
        Log.d(TAB,"step2 :" +
                member.getName());
        tvName.setText(member.getName());
        tvAddress.setText(member.getAddress());
        Glide.with(this)
                .load(member.getImage1())
                .into(ivMenu);
//        Log.d(TAB,"step3");
//        DetailFragment detailFragment = new DetailFragment();
//        detailFragment.setArguments(bundle);
//        fragmentManager = getSupportFragmentManager();
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        ft.add(detailFragment , TAB).commit();


    }



}
