package com.example.catherine.foodproject;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MemberFragment extends Fragment {
    private Member member;


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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.member_fragment, container, false);
        ImageView ivImage = (ImageView) view
                .findViewById(R.id.ivImage);
        ivImage.setImageResource(member.getImage());

        TextView tvDistance = (TextView) view
                .findViewById(R.id.tvDistance);
        tvDistance.setText(String.valueOf(member.getDistance()));

        TextView tvName = (TextView) view
                .findViewById(R.id.tvName);
        tvName.setText(member.getName());
        Button btExplore = (Button)view
                .findViewById(R.id.btExplore);


        return view;

    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Button btExplore = (Button)getActivity().findViewById(R.id.btExplore);
//        btExplore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
}
