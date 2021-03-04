package com.example.btvn5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btvn5.databinding.ActivityMain3Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    int countCart=0;
    TextView tvCountCart;
    ActivityMain3Binding binding;

    long monney;

    List<drink> listDrinkToCart;


    public void setMonney(long monney) {
        this.monney = monney;
    }

    public void setCountCart(int countCart) {
        this.countCart = countCart;
    }

    public int getCountCart() {
        return countCart;
    }

    public List<drink> getListDrinkToCart() {
        return listDrinkToCart;
    }

    public void setListDrinkToCart(List<drink> listDrinkToCart) {
        this.listDrinkToCart = listDrinkToCart;
    }

    BottomNavigationView navigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity3.this, R.layout.activity_main3);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        //
        //biến số lượng Cart
        tvCountCart=findViewById(R.id.tvCountCart);

        //lấy userName từ login
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            binding.logname.setText(bundle.getString("userName", "Phòng hotboy"));
        }
        getFragment (fragment1.newInstance());





//        viewPager=findViewById(R.id.viewPager);
//        setUpViewPager();
//        viewPager.setCurrentItem(0);

        navigationView=findViewById(R.id.nav_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.bell:
                        getFragment(fragment2.newInstance());
//                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.cart:
                        getFragment(fragment3.newInstance(listDrinkToCart, countCart,  monney));
//                        viewPager.setCurrentItem(2);
                        break;
                    default:
                        getFragment(fragment1.newInstance());
//                        viewPager.setCurrentItem(0);
                        break;



                }
                return true;
            }
        });


//
//
//    }
//
//    public void setUpViewPager (){
//        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPager.setAdapter(viewPagerAdapter);
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position){
//                    case 1:
//                        navigationView.getMenu().findItem(R.id.bell).setChecked(true);
//                        break;
//                    case 2:
//                        navigationView.getMenu().findItem(R.id.cart).setChecked(true);
//
//                        break;
//                    case 0:
//                        navigationView.getMenu().findItem(R.id.homeme).setChecked(true);
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    private void getFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, fragment).commit();
    }

    public TextView getTvCountCart() {
        return tvCountCart;
    }

}