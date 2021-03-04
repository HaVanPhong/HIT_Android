package com.example.btvn5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.btvn5.databinding.LayoutFragment2Binding;

public class fragment2 extends Fragment {
    LayoutFragment2Binding binding;
    public static fragment2 newInstance() {

        Bundle args = new Bundle();

        fragment2 fragment = new fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.layout_fragment2, container, false);

        return binding.getRoot();
    }
}
