package com.example.catherine.foodproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/8/28.
 */

public class DetailFragment extends Fragment {

    private Member member;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            member = (Member) getArguments().getSerializable("member");
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.detial_fragment, container, false);
        ImageView ivMenu = (ImageView) view
                .findViewById(R.id.ivMenu);
        ivMenu.setImageResource(member.getImage1());

        TextView tvAddress = (TextView) view
                .findViewById(R.id.tvAddress);
        tvAddress.setText(String.valueOf(member.getAddress()));

        TextView tvName = (TextView) view
                .findViewById(R.id.tvName);
        tvName.setText(member.getName());


        return view;

    }
}
