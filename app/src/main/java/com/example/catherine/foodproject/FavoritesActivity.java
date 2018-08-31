package com.example.catherine.foodproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class FavoritesActivity extends AppCompatActivity {
    private final static String TAB ="FavoritesActivity";
    private TextView tvName;
    private TextView tvAddress;
    private ImageView ivImage;
    private TextView tvCuisine;
    private RatingBar rbPriceEvaluation;
    private TextView tvDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        findViews();

        //將Tabhost初始化
        TabHost tabhost = (TabHost)findViewById(R.id.tabhost);
        tabhost.setup();

        LayoutInflater.from(this).inflate(R.layout.activity_favorites , tabhost.getTabContentView());
        tabhost.addTab(tabhost.newTabSpec("tab1").setIndicator("Liked").setContent(R.id.Liked));
        tabhost.addTab(tabhost.newTabSpec("tab2").setIndicator("SuperLiked").setContent(R.id.SuperLiked));
        tabhost.setCurrentTab(0);

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener(){
            @Override
            // tabId是newTabSpec第一個參數設置的tab頁名，不是layout裡面的標示符id
            public void onTabChanged(String tabId) {
                if (tabId.equals("tab1")) {
                    Toast.makeText(FavoritesActivity.this, "點擊標籤頁Liked", Toast.LENGTH_SHORT).show();
                    showResults();
                }
                if (tabId.equals("tab2")) {
                    Toast.makeText(FavoritesActivity.this, "點擊標籤頁SuperLiked", Toast.LENGTH_SHORT).show();
                    showResults();
                }
            }
        });

        //接收被點擊Like與SuperLike的餐廳資訊顯示在RecyclerView上
        RecyclerView rvLiked =(RecyclerView) findViewById(R.id.rvLiked);
        rvLiked.setLayoutManager(new LinearLayoutManager(FavoritesActivity.this, LinearLayoutManager.VERTICAL,false));
//        rvLiked.setAdapter();

    }
    public void findViews(){
        tvName = (TextView)findViewById(R.id.tvName);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        ivImage = (ImageView)findViewById(R.id.ivImage);
        tvCuisine = (TextView)findViewById(R.id.tvCuisine);
        rbPriceEvaluation = (RatingBar) findViewById(R.id.rbPriceEvaluation);
        tvDistance = (TextView)findViewById(R.id.tvDistance);
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
                .load(member.getImage())
                .into(ivImage);
        tvCuisine.setText(member.getCuisineType());
        rbPriceEvaluation.setRating(member.getPriceEvaluation());
        tvDistance.setText(member.getDistance());
    }

}

