package com.example.catherine.foodproject;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class DetialActivity extends AppCompatActivity {
    private final static String TAB = "DetialActivity";
    private TextView tvName;
    private TextView tvAddress;
    private ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detial_fragment);
        findViews();
        showResults();

    }

    //初始化元件
    public void findViews() {
        tvName = findViewById(R.id.tvName);
        tvAddress = findViewById(R.id.tvAddress);
        ivMenu = findViewById(R.id.ivMenu);
    }

    //接收餐廳資訊，於頁面上顯示店名、地址、Menu
    private void showResults() {
        Log.d(TAB, "step1");
        Bundle bundle = getIntent().getExtras();
        Member member = (Member) bundle.getSerializable("member");
        Log.d(TAB, "step2 :" +
                member.getName());
        tvName.setText(member.getName());
        tvAddress.setText(member.getAddress());
        Glide.with(this)
                .load(member.getImage1())
                .into(ivMenu);

    }
}
