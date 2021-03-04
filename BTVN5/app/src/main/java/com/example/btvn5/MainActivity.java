package com.example.btvn5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.btvn5.databinding.ActivityMainBinding;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.Wave;

public class MainActivity extends AppCompatActivity {
//    Button btnLogin, btnRegister;
//    EditText tvUsername;
//    ProgressBar progressBar;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
//        AnhXa();
//        binding.fragmentProgressBar.setIndeterminateDrawable(new DoubleBounce());





        Handler handler=new Handler();
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=binding.tvUsername.getText().toString();
                String pass=binding.tvPassword.getText().toString();

                boolean checkLogin=false;
                if (pass.length()<6){
                    Toast.makeText(MainActivity.this, "Mật khẩu cần có trên 6 kí tự", Toast.LENGTH_SHORT).show();
                    checkLogin=false;
                }else
                if (!pass.matches(".*[A-Z].*")){
                    Toast.makeText(MainActivity.this, "Mật khẩu cần có ít nhất 1 kí tự in hoa", Toast.LENGTH_SHORT).show();
                    checkLogin=false;
                }else if (user.length()==0){
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập Username", Toast.LENGTH_SHORT).show();
                    checkLogin=false;
                }
                else{
                    checkLogin=true;
                }

                if (checkLogin){
                    getFragment(dialog_custom_frag.newInstance());
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent1=new Intent(MainActivity.this, MainActivity3.class);
                            Bundle bundle=new Bundle();
                            bundle.putString("userName", binding.tvUsername.getText()+"");
                            intent1.putExtras(bundle);
                            startActivity(intent1);

                        }
                    }, 1000);

                }

            }
        });


    }
    public void getFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_progressBar, fragment).commit();

    }
//    void AnhXa(){
//        btnLogin=findViewById(R.id.btnLogin);
//        btnRegister=findViewById(R.id.btnRegister);
//        tvUsername=findViewById(R.id.tvUsername);
//        progressBar= findViewById(R.id.proBar);
//    }

}