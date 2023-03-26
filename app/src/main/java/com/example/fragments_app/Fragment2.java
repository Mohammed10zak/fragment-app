package com.example.fragments_app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fragments_app.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {

    private OnContinueButtonClickListener listener;
    public static Fragment2Binding fragment2Binding;


    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnContinueButtonClickListener) {
            listener = (OnContinueButtonClickListener) context;
        } else {
            throw new ClassCastException("failed");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment2Binding = Fragment2Binding.inflate(inflater, container, false);
        return fragment2Binding.getRoot();

    }

    public interface OnContinueButtonClickListener {
    }

}


