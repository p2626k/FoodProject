package com.example.catherine.foodproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class

FavoritesActivity extends AppCompatActivity {
    private final static String TAB = "FavoritesActivity";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        tabLayout = findViewById(R.id.tabLayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        //Add Fragment here
        Bundle bundle = new Bundle();
        Member member = (Member) getIntent().getSerializableExtra("member");
        bundle.putSerializable("member", member);

        LikedFragment likedFragment = new LikedFragment();
        likedFragment.setArguments(bundle);
        SuperLikedFragment superLikedFragment = new SuperLikedFragment();
        superLikedFragment.setArguments(bundle);
        viewPagerAdapter.addFragment(likedFragment, "Liked");
        viewPagerAdapter.addFragment(superLikedFragment, "SuperLiked");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //Remove Shadow from the ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
    }


}

