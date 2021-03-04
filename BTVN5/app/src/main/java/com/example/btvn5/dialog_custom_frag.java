package com.example.btvn5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.btvn5.databinding.DialogCustomBinding;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.Wave;

public class dialog_custom_frag extends Fragment {
    DialogCustomBinding binding;
    public static dialog_custom_frag newInstance() {
        Bundle args = new Bundle();

        dialog_custom_frag fragment = new dialog_custom_frag();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater, R.layout.dialog_custom, container, false);
        binding.proBar.setIndeterminateDrawable(new Wave());
        return binding.getRoot();
    }
}
