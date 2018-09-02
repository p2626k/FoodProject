package com.example.catherine.foodproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class

FavoritesActivity extends AppCompatActivity {
    private final static String TAB ="FavoritesActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager)findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Add Fragment here
        viewPagerAdapter.addFragment(new LikedFragment(), "Liked");
        viewPagerAdapter.addFragment(new SuperLikedFragment(), "SuperLiked");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //Remove Shadow from the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }


}

