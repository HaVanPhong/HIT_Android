package com.example.btvn5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn5.databinding.LayoutFragment1Binding;

import java.util.ArrayList;
import java.util.List;

public class fragment1 extends Fragment {

    long monney=0;
    List<drink> list = new ArrayList<>();

    List<drink> listCart = new ArrayList<>();
    LayoutFragment1Binding binding;

    MainActivity3 mainActivity3;

    int countCart =0;
    public static fragment1 newInstance() {
        fragment1 fragment = new fragment1();

        Bundle args = new Bundle();


        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment1, container, false);

        mainActivity3 = (MainActivity3) getActivity();

        list.add(new drink(R.mipmap.biacorona, 10, 0, "Corona Beer"));
        list.add(new drink(R.mipmap.biaipa, 20, 0, "Ipa Beer"));
        list.add(new drink(R.mipmap.nen, 50, 0, "Bla Bla"));
        list.add(new drink(R.mipmap.nencoc, 5, 0, "CocBeer"));
        list.add(new drink(R.mipmap.ruoudua, 30, 0, "Dua alcohol"));
        list.add(new drink(R.mipmap.ruouremymatri, 45, 0, "Matrix alcohol"));
        list.add(new drink(R.mipmap.strongbow, 20, 0, "Strongbow"));
        list.add(new drink(R.mipmap.nene, 40, 0, "Friends Beer"));
        list.add(new drink(R.mipmap.biaipa, 80, 0, "Mlem"));

        drinkAdapter adapter = new drinkAdapter(list, getContext());


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);

        adapter.setiOnclick(new IOnclick() {
            @Override
            public void iOnclickTru(drink drink) {
                countCart--;
                monney-=drink.getCore();
                drink.setCount(drink.getCount()-1);

                removeDrinkOnListCart(drink);
                sendDatatoActivity3();

            }

            @Override
            public void iOnclickCong(drink drink) {
                countCart++;
                monney+=drink.getCore();
                drink.setCount(drink.getCount()+1);

                addDrinkToListCart(drink);
                sendDatatoActivity3();

            }
        });


        return binding.getRoot();
    }

    public void sendDatatoActivity3() {
        mainActivity3.getTvCountCart().setText(countCart + "");
        mainActivity3.setCountCart(countCart);

        mainActivity3.setMonney(monney);
        mainActivity3.setListDrinkToCart(listCart);
    }

    public void addDrinkToListCart(drink drink) {

        boolean check = true;
        int size = listCart.size();
        for (int i = 0; i < size; i++) {
            if (drink.getName().compareTo(listCart.get(i).getName()) == 0){
                //                drink.setCount(countCart);
                listCart.remove(i);
                listCart.add(drink);
                check = false;
            }
        }
        if (check) listCart.add(drink);
    }
    public void removeDrinkOnListCart(drink drink){
        int size = listCart.size();
        if (drink.getCount()==0){
            for (int i = 0; i < size; i++) {
                if (drink.getName().compareTo(listCart.get(i).getName()) == 0){
                    listCart.remove(i);
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (drink.getName().compareTo(listCart.get(i).getName()) == 0){
                    listCart.remove(i);
                    listCart.add(drink);
                    break;
                }
            }

        }
    }
}
