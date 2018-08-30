package com.example.catherine.foodproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.List;


public class FavoritesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

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
                }
                if (tabId.equals("tab2")) {
                    Toast.makeText(FavoritesActivity.this, "點擊標籤頁SuperLiked", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //接收被操作Yes按鈕或右滑的餐廳資訊顯示在ListView上
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(FavoritesActivity.this, LinearLayoutManager.VERTICAL,false));




    }


}

