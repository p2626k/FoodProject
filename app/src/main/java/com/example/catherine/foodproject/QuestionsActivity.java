package com.example.catherine.foodproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class QuestionsActivity extends AppCompatActivity {
    CheckBox cbBreakfast, cbBrunch, cbLunch, cbMunchies, cbDinner, cbDrinks, cbAmerican, cbFrench, cbMexican,
            cbJapanese, cbThai, cbVietnam, cbPizza, cbDesserts, cbChinese, cbItalian, cbVegetarian, cbMedeteranian;
    RatingBar rbPriceEvaluation;
    Button btDone, btCancel;
    ArrayList<String> cuisineMsg = new ArrayList<>();
    ArrayList<String> foodMsg = new ArrayList<>();
    float priceEvaluationResult;
    //CheckBox複選控制
    private CompoundButton.OnCheckedChangeListener checkBoxOnCheckedChange =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { //buttonView 為目前觸發此事件的 CheckBox, isChecked 為此 CheckBox 目前的選取狀態
//                    tvShowC.setText("");
//                    tvShowF.setText("");
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        takeOrder(buttonView);
                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        takeOrder(buttonView);
                    }
                }
            };
    //RatingBar監聽器
    private RatingBar.OnRatingBarChangeListener ratingBarOnCheckedChange = new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            float k = rbPriceEvaluation.getRating();
//        tvShowR.setText(String.valueOf(k));
            priceEvaluationResult = k;
        }
    };
    //Button監聽器
    private Button.OnClickListener OnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btDone:
                    // 按下Done，傳送使用者選擇條件回HomeActivity進行條件比對與viewPager畫面更新
                    Intent intentD = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("cuisine", cuisineMsg);
                    bundle.putStringArrayList("foodType", foodMsg);
                    bundle.putFloat("priceEvaluation", priceEvaluationResult);
                    intentD.putExtra("condition", bundle);
                    QuestionsActivity.this.setResult(RESULT_OK, intentD);
                    finish();
                    break;
                case R.id.btCancel:
                    //按下Cancel則返回HomeActivity頁面
                    Intent intentC = new Intent(QuestionsActivity.this, HomeActivity.class);
                    startActivity(intentC);
                    break;


            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        //初始化元件
        findViews();
        setListener();
    }

    private void findViews() {
        cbBreakfast = findViewById(R.id.cbBreakfast);
        cbBrunch = findViewById(R.id.cbBrunch);
        cbLunch = findViewById(R.id.cbLunch);
        cbMunchies = findViewById(R.id.cbMunchies);
        cbDinner = findViewById(R.id.cbDinner);
        cbDrinks = findViewById(R.id.cbDrinks);
        cbAmerican = findViewById(R.id.cbAmerican);
        cbFrench = findViewById(R.id.cbFrench);
        cbMexican = findViewById(R.id.cbMexican);
        cbJapanese = findViewById(R.id.cbJapanese);
        cbThai = findViewById(R.id.cbThai);
        cbVietnam = findViewById(R.id.cbVietnam);
        cbPizza = findViewById(R.id.cbPizza);
        cbDesserts = findViewById(R.id.cbDesserts);
        cbChinese = findViewById(R.id.cbChinese);
        cbItalian = findViewById(R.id.cbItalian);
        cbVegetarian = findViewById(R.id.cbVegetarian);
        cbMedeteranian = findViewById(R.id.cbMedeteranian);
        rbPriceEvaluation = findViewById(R.id.rbPriceEvaluation);
        btDone = findViewById(R.id.btDone);
        btCancel = findViewById(R.id.btCancel);

    }

    //設定監聽器
    private void setListener() {
        //設定CheckBox監聽器
        cbBreakfast.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbBrunch.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbLunch.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbMunchies.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbDinner.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbDrinks.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbAmerican.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbFrench.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbMexican.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbJapanese.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbThai.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbVietnam.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbPizza.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbDesserts.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbChinese.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbItalian.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbVegetarian.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        cbMedeteranian.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        //設定RatingBar監聽器
        rbPriceEvaluation.setOnRatingBarChangeListener(ratingBarOnCheckedChange);
        //設定Button監聽器
        btDone.setOnClickListener(OnClick);
        btCancel.setOnClickListener(OnClick);

    }

    public void takeOrder(View v) {
        CheckBox cuisineType;
        CheckBox foodType;


        // 用陣列存放所有 CheckBox 元件的 ID
        int[] cuisineId = {R.id.cbAmerican, R.id.cbFrench, R.id.cbMexican, R.id.cbJapanese,
                R.id.cbThai, R.id.cbVietnam, R.id.cbPizza, R.id.cbDesserts,
                R.id.cbChinese, R.id.cbItalian, R.id.cbVegetarian, R.id.cbMedeteranian};
        int[] foodId = {R.id.cbBreakfast, R.id.cbBrunch, R.id.cbLunch, R.id.cbMunchies, R.id.cbDrinks, R.id.cbDinner};


        for (int i : cuisineId) {    // 以迴圈逐一檢視各 CheckBox 是否被選取
            cuisineType = (CheckBox) findViewById(i);
            if (cuisineType.isChecked())            // 若有被選取
                cuisineMsg.add(cuisineType.getText().toString());   // 將換行字元及選項文字附加到 cuisineMsg 字串後面
        }
        for (int j : foodId) {    // 以迴圈逐一檢視各 CheckBox 是否被選取
            foodType = (CheckBox) findViewById(j);
            if (foodType.isChecked())            // 若有被選取
                foodMsg.add(foodType.getText().toString());   // 將換行字元及選項文字附加到 foodMsg 字串後面
        }

    }

    //建立onKeyDown()，當使用者按下返回鍵則返回HomeActivity頁面
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            //當使用者按下返回鍵且沒有重複，HomeActivity
            Intent intent = new Intent(QuestionsActivity.this, HomeActivity.class);
            startActivity(intent);

            this.finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
