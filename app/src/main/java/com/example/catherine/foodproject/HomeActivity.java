package com.example.catherine.foodproject;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private List<Member> memberList;
    private ViewPager vpMember;
    private EditText etEmail;
    private EditText etPassword;
    private Button btSearch;
    private Button btLike;
    private final static String TAG = "HomeActivity";
    private int position ;
    private int vpPager = 0;
    private Button btExplore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate");
        findViews();

        //取得餐廳清單後傳至MemberAdapter的建構式，ViewPager再套用該MemberAdapter即可顯示所有餐廳資訊
        List<Member> memberList = getMemberList();
        MemberAdapter memberAdapter = new MemberAdapter(getSupportFragmentManager(), memberList);
        vpMember = (ViewPager) findViewById(R.id.vpMember);
        vpMember.setAdapter(memberAdapter);
        //設定ViewPager監聽器取得索引值position
        vpMember.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                vpPager = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //按下Search按鈕則轉至QuestionsActivity頁面
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                startActivity(intent);
            }
        });
        //按下Like按鈕則轉至FavoritesActivity頁面
        btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    public void findViews() {
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btSearch = (Button) findViewById(R.id.btSearch);
        btLike = (Button) findViewById(R.id.btLike);
    }

    //建立餐廳清單
    private List<Member> getMemberList() {
        memberList = new ArrayList<>();
        memberList.add(new Member("Lady M", R.drawable.s1, "15km", R.drawable.m1, "台北市大安區光復南路240巷26號", 5, "Desserts", "Munchies"));
        memberList.add(new Member("吉星", R.drawable.s2, "12km", R.drawable.m2, "台北市南京東路一段92號2樓", 3, "Chinese", "Lunch"));
        memberList.add(new Member("教父牛排", R.drawable.s3, "16km", R.drawable.m3, "台北市中山區樂群三路58號", 5, "American", "Dinner"));
        memberList.add(new Member("大腕燒烤", R.drawable.s4, "14.2km", R.drawable.m4, "台北市大安區敦化南路一段177巷22號", 4, "American", "Dinner"));
        memberList.add(new Member("鮨野村", R.drawable.s5, "16.6km", R.drawable.m5, "台北市大安區仁愛路四段300巷19弄4號", 4, "Japanese", "Dinner"));
        memberList.add(new Member("RAW", R.drawable.s6, "10.6km", R.drawable.m6, "台北市中山區樂群三路301號", 5, "French", "Dinner"));
        memberList.add(new Member("My灶", R.drawable.s7, "12.3km", R.drawable.m7, "台北市中山區松江路100巷9-1號", 3, "Chinese", "Lunch"));
        memberList.add(new Member("阜杭豆漿", R.drawable.s8, "12.6km", R.drawable.m8, "台北市中正區忠孝東路一段108號", 1, "Chinese", "Breakfast"));
        memberList.add(new Member("雙連圓仔湯", R.drawable.s9, "10.4km", R.drawable.m9, "台北市大同區民生西路136號", 1, "Desserts", "Munchies"));
        memberList.add(new Member("思慕昔", R.drawable.s10, "13.1km", R.drawable.m10, "台北市大安區永康街15號", 2, "Desserts", "Munchies"));

        return memberList;
    }

    //按下Yes按鈕，資料傳送到FavoritesActivity頁面顯示於RecyclerView上

    //按下No按鈕，資料刪除


    //建立onKeyDown()，當使用者按下返回鍵則返回LoginActivity頁面，清除LoginActivity的帳號密碼
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //當使用者按下返回鍵且沒有重複，則返回LoginActivity頁面
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            // 清除LoginActivity的帳號密碼

            etEmail = null;
            etPassword = null;
            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //MemberAdapter繼承FragmentStatePagerAdapter後改寫getItem()與getCount()以提供ViewPager各頁內容
    private class MemberAdapter extends FragmentStatePagerAdapter {
        List<Member> memberList;

        //MemberAdapter建構式接到memberList餐廳清單後指派給實體變數，方便之後使用
        private MemberAdapter(FragmentManager fm, List<Member> memberList) {
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

        //改寫getCount()提供總共頁數，在此回傳餐廳總數，代表一頁顯示一間餐廳資訊
        @Override
        public int getCount() {
            return memberList.size();
        }



    }
}
