package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {
    TextInputLayout textInput;
    TextInputEditText edtinput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        setupFloatingLableError();
    }

//    private void setupFloatingLableError() {
//        textInput=findViewById(R.id.textInput);
//        edtinput=findViewById(R.id.edtinput);
//        textInput.getEditText().addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                if (s.length()==0){
//                    textInput.setError("cần nhập vào đây");
//                    textInput.setErrorEnabled(true);
//                }else if (s.length()<5){
//                    textInput.setError("cần nhần >5 ký tự");
//                    textInput.setErrorEnabled(true);
//                }else
//                {
//                    textInput.setErrorEnabled(false);
//                }
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
}