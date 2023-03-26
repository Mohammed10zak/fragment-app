package com.example.fragments_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment3 extends Fragment {
    private static String ARG_Name;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String ARG_Kay = "name";
            ARG_Name = bundle.getString(ARG_Kay);
        }
    }

    public static Fragment3 newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        Fragment3 fragment3 = new Fragment3();
        fragment3.setArguments(bundle);
        return fragment3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_3, container, false);
        TextView tvName = v.findViewById(R.id.tvName);
        tvName.setText(ARG_Name);
        return v;
    }

}