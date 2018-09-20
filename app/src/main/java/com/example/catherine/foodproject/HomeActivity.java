package com.example.catherine.foodproject;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private final static String TAG = "HomeActivity";
    private final static int EDIT = 1;
    DatabaseReference reference;
    List<Member> memberList;
    ArrayList<String> resultCuisine = new ArrayList<>();
    ArrayList<String> resultFoodType = new ArrayList<>();
    List<Member> conditionMemberList = new ArrayList<>();
    private ViewPager vpMember;
    private EditText etEmail;
    private EditText etPassword;
    private Button btSearch;
    private Button btFavorite;
    private int position;
    private int vpPager = 0;
    private float resultPriceEvaluation;

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
            //firebase資料取得
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Member member = dataSnapshot1.getValue(Member.class);
                    memberList.add(member);
                }
                resetPager(memberList);
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
                Toast.makeText(HomeActivity.this, "something is wrong...", Toast.LENGTH_SHORT).show();
            }
        });


        //按下Search按鈕則轉至QuestionsActivity頁面
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, QuestionsActivity.class);
                //使用startActivityForResult，回傳QuestionsActivity搜尋結果
                startActivityForResult(intent, EDIT);
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
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btSearch = findViewById(R.id.btSearch);
        btFavorite = findViewById(R.id.btFavorite);
        vpMember = findViewById(R.id.vpMember);
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

    //使用startActivityResult需要複寫onActivityResult取得傳回資料
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == EDIT) {
                resultCuisine = data.getBundleExtra("condition").getStringArrayList("cuisine");
                resultFoodType = data.getBundleExtra("condition").getStringArrayList("foodType");
                resultPriceEvaluation = data.getBundleExtra("condition").getFloat("priceEvaluation");
                compareItem();
                resetPager(conditionMemberList);
            }
        }
    }

    //依照不同結果得到的List塞到MemberAdapter，得到需求畫面
    private void resetPager(List<Member> memberList) {
        MemberAdapter memberAdapter = new MemberAdapter(getSupportFragmentManager(), memberList);
        vpMember.setAdapter(memberAdapter);
    }

    //比對條件後更新viewPager
    private void compareItem() {
        for (int i = 0; i < memberList.size(); i++) {
            //如果cuisine條件符合，取得memberList符合條件之成員
            for (int j = 0; j < resultCuisine.size(); j++) {
                if (resultCuisine.contains(memberList.get(i).getCuisineType())) {
                    if (!conditionMemberList.contains(memberList.get(i))) {
                        conditionMemberList.add(memberList.get(i));
                    }
                }
            }
        }
        for (int i = 0; i < memberList.size(); i++) {
            //如果foodType條件符合，取得memberList符合條件之成員
            for (int k = 0; k < resultFoodType.size(); k++) {
                if (resultFoodType.contains(memberList.get(i).getFoodType())) {
                    if (!conditionMemberList.contains(memberList.get(i))) {
                        conditionMemberList.add(memberList.get(i));
                    }
                }
            }
        }
        for (int i = 0; i < memberList.size(); i++) {
            //如果priceEvaluation條件符合，取得memberList符合條件之成員
            if (resultPriceEvaluation == memberList.get(i).getPriceEvaluation()) {
                if (!conditionMemberList.contains(memberList.get(i))) {
                    conditionMemberList.add(memberList.get(i));
                }
            }
        }
        //判斷conditionMemberList是否為空值或空集合
        if (conditionMemberList == null || conditionMemberList.size() == 0) {
            //如果conditionMemberList為空值或空集合，則顯示"尚未搜尋到符合條件的餐廳!請重新選取條件!"
            Toast.makeText(getApplicationContext(), "尚未搜尋到符合條件的餐廳!請重新選取條件!", Toast.LENGTH_LONG).show();
        } else {
            //如果conditionMemberList不為空值或空集合，則回傳
            return;
        }

    }

}
