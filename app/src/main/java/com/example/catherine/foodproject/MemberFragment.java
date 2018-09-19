package com.example.catherine.foodproject;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MemberFragment extends Fragment {
    private Member member;
    private static final String TAG = "MemberFragment";

    //取得餐廳物件後指派給實體變數，方便onCreateView()使用
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            member = (Member) getArguments().getSerializable("member");
        }
    }
    //將餐廳物件member的相關資料取出後顯示在ImageView與TextView上
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment, container, false);
        ImageView ivImage = (ImageView) view
                .findViewById(R.id.ivImage);
        Glide.with(this)
                .load(member.getImage())
                .into(ivImage);

        TextView tvDistance = (TextView) view
                .findViewById(R.id.tvDistance);
        tvDistance.setText(String.valueOf(member.getDistance()));

        TextView tvName = (TextView) view
                .findViewById(R.id.tvName);
        tvName.setText(member.getName());
        //按下Explore按鈕則將資料轉至DetialActivity頁面
        Button btExplore = (Button) view.findViewById(R.id.btExplore);
        btExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetialActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("member" , member);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //按下Like按鈕，資料傳送到FavoritesActivity頁面顯示於Tab的Like標籤RecyclerView上
        Button btLike = (Button) view.findViewById(R.id.btLike);
        btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference("liked");
                    database.child(String.valueOf(member.getId())).setValue(member);
                    Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("member", member);
                    intent.putExtras(bundle);
            }
        });
        //按下SuperLike按鈕，資料傳送到FavoritesActivity頁面顯示於Tab的SuperLike標籤RecyclerView上
        Button btSuperLike = (Button) view.findViewById(R.id.btSuperLike);
        btSuperLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference database = FirebaseDatabase.getInstance().getReference("superliked");
                    database.child(String.valueOf(member.getId())).setValue(member);
                    Intent intent = new Intent(getActivity(), FavoritesActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("member" , member);
                    intent.putExtras(bundle);
            }
        });

        return view;

    }

}
