package com.example.btvn5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn5.databinding.LayoutFragment3Binding;

import java.util.ArrayList;
import java.util.List;

public class fragment3 extends Fragment {
    long monney;
    int countCart = 0;

    boolean checkUpdate=false;
    LayoutFragment3Binding binding;
    MainActivity3 mainActivity3;
    List<drink> listCart = new ArrayList<>();

    public static fragment3 newInstance(List<drink> list, int countCart, long monney) {

        Bundle args = new Bundle();
        args.putParcelableArrayList("listDrinkToCart", (ArrayList<? extends Parcelable>) list);
        args.putInt("countCart", countCart);
        args.putLong("monney", monney);
        fragment3 fragment = new fragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment3, container, false);

        mainActivity3 = (MainActivity3) getActivity();


//        for (int i = 0; i < listCart.size(); i++) {
//            monney += listCart.get(i).getCore();
//            binding.tvPrive.setText(monney + "$");
//        }
        countCart = getArguments().getInt("countCart", 0);
        monney = getArguments().getLong("monney", 0);
        listCart = getArguments().getParcelableArrayList("listDrinkToCart");

        drinkAdapter adapter = new drinkAdapter(listCart, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerViewCart.setLayoutManager(layoutManager);
        binding.recyclerViewCart.setAdapter(adapter);

        TinhTien();
        adapter.setiOnclick(new IOnclick() {
            @Override
            public void iOnclickTru(drink drink) {
                if (checkUpdate)
                    Update();
                countCart--;
                sendDataToMainActivity3();
                monney -= drink.getCore();
                drink.setCount(drink.getCount() - 1);
                TinhTien();
                removeDrinkOnListCart(drink);
            }

            @Override
            public void iOnclickCong(drink drink) {
//                if (checkUpdate)
//                    Update();
                countCart++;
                sendDataToMainActivity3();
                monney += drink.getCore();
//                drink.setCount(drink.getCount()+1);
                TinhTien();

            }
        });
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogShow();
            }
        });
        return binding.getRoot();
    }

    public void sendDataToMainActivity3() {
        mainActivity3.setCountCart(countCart);
        mainActivity3.getTvCountCart().setText(countCart + "");

    }

    public void TinhTien() {
        binding.tvPrive.setText(monney + "$");
    }

    public void Update() {
        drinkAdapter adapter = new drinkAdapter(listCart, getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        binding.recyclerViewCart.setLayoutManager(layoutManager);
        binding.recyclerViewCart.setAdapter(adapter);
    }

    public void removeDrinkOnListCart(drink drink) {
        if (drink.getCount() == 0) {
            int size = listCart.size();
            for (int i = 0; i < size; i++) {
                if (drink.getName().compareTo(listCart.get(i).getName()) == 0) {
                    listCart.remove(i);
                    break;
                }
            }
            checkUpdate=true;
            Update();
        }

    }

    public void onDialogShow() {
        AlertDialog dialog = new AlertDialog.Builder(getContext())
                .setTitle("CONFIRM ORDER")
                .setMessage("Xác nhận thanh toán: " + monney + "$")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "Succcess", Toast.LENGTH_SHORT).show();
                        listCart.removeAll(listCart);
                        Update();
                        monney=0;
                        mainActivity3.setMonney(monney);
                        TinhTien();
                        mainActivity3.tvCountCart.setText("0");
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).create();
        dialog.show();
    }
}
