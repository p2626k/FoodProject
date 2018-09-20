package com.example.catherine.foodproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by ASUS on 2018/9/5.
 */
//MemberAdapter繼承FragmentStatePagerAdapter後改寫getItem()與getCount()以提供ViewPager各頁內容

public class MemberAdapter extends FragmentStatePagerAdapter {
    List<Member> memberList;


    //MemberAdapter建構式接到memberList餐廳清單後指派給實體變數，方便之後使用
    public MemberAdapter(FragmentManager fm, List<Member> memberList) {
        super(fm);
        this.memberList = memberList;

    }

    //改寫getItem()並依照position位置取得對應Member物件後以setArgument()方式將該物件加在Fragment上方便之後在Fragment內取得Member物件並利用
    @Override
    public Fragment getItem(int position) {
        Member member = memberList.get(position);
        MemberFragment fragment = new MemberFragment();
        Bundle args = new Bundle();
        args.putSerializable("member", member);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    //改寫getCount()提供總共頁數，在此回傳餐廳總數，代表一頁顯示一間餐廳資訊
    @Override
    public int getCount() {
        return memberList.size();
    }

}
