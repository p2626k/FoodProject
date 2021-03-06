package com.example.catherine.foodproject;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btSignIn;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findviews();  //初始化需要使用的物件

        //設定Sign in按鈕監聽器
        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String  account ="aaa@gmail.com";
//                String  password ="111";
                //密碼與帳號都符合時，登入HomeActivity
//                    if(etEmail.getText().toString().equals(account) && etPassword.getText().toString().equals(password)){
                Intent intent = new Intent(LoginActivity.this , HomeActivity.class);
                startActivity(intent);
//                    }else{//密碼帳號不符合時於下方TextView顯示"輸入錯誤，請重新登入"
//                        tvShow.setText("輸入錯誤，請重新登入");
            }
//                }


        });
    }
    private void findviews() {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btSignIn = findViewById(R.id.btSignIn);
        tvShow = findViewById(R.id.tvShow);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //當使用者按下返回鍵且沒有重複，則關閉程式
            Context mContext = getBaseContext();
            ActivityManager activityMgr = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
            mContext.stopService(new Intent(mContext, LoginActivity.class));
            activityMgr.killBackgroundProcesses(mContext.getPackageName());
        }
        return super.onKeyDown(keyCode, event);
    }


}
