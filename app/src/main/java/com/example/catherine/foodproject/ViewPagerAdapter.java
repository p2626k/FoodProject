package com.example.catherine.foodproject;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/9/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List <Fragment> listFragment = new ArrayList<>();
    private final List <String> listTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }
    public void addFragment(Fragment fragment, String title){
        listFragment.add(fragment);
        listTitles.add(title);
    }
}