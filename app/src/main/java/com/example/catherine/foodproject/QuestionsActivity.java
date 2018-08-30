package com.example.catherine.foodproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuestionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //CheckBox複選控制
            //設定CheckBox監聽器
        //設定RatingBar監聽器
        //設定SeekBar監聽器

        //條件選畢
            // 按下Done
                //若條件符合則HomeActivity只顯示符合條件的餐廳
                //若條件不符合則QuestionsActivity頁面顯示Toast"目前尚未搜尋到符合條件的餐廳，請重新設定條件"
            //按下Cancel則返回HomeActivity頁面
    }
}
