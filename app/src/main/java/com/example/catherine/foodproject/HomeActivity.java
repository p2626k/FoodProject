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
import android.widget.Toast;


import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    DatabaseReference reference;
    List<Member> memberList;
    private ViewPager vpMember;
    private EditText etEmail;
    private EditText etPassword;
    private Button btSearch;
    private Button btFavorite;
    private final static String TAG = "HomeActivity";
    private int position ;
    private int vpPager = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate");
        findViews();

        //取得餐廳清單後傳至MemberAdapter的建構式，ViewPager再套用該MemberAdapter即可顯示所有餐廳資訊
        memberList = new ArrayList<Member>();
        reference = FirebaseDatabase.getInstance().getReference().child("restaurant");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Member member = dataSnapshot1.getValue(Member.class);
                    memberList.add(member);
                }
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(HomeActivity.this,"something is wrong...",Toast.LENGTH_SHORT).show();
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
        //按下Favorite按鈕則轉至FavoritesActivity頁面
        btFavorite.setOnClickListener(new View.OnClickListener() {
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
        btFavorite = (Button) findViewById(R.id.btFavorite);
    }


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

}
