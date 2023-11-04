package com.example.navigationbottom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationbottom.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {
    private EditText edtTaiKhoan, edtMauKhau;
    private Button btnLogin;
    private TextInputLayout edtLayoutTaikhoan, edtLayoutMatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        edtTaiKhoan = findViewById(R.id.edt_taiKhoan);
        edtMauKhau = findViewById(R.id.edt_matkhau);
        edtLayoutTaikhoan = findViewById(R.id.edtlayout_taikhoan);
        edtLayoutMatkhau = findViewById(R.id.edtlayout_matkhau);
        btnLogin = findViewById(R.id.btn_logout);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTaiKhoan.getText().toString().isEmpty() || edtMauKhau.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Bạn chưa nhập tài khoản, mật khẩu!", Toast.LENGTH_LONG).show();
                }else if(edtTaiKhoan.getText().toString().equals("t") && edtMauKhau.getText().toString().equals("t")){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Bạn nhập sai tài khoản hoặc mật khẩu!", Toast.LENGTH_LONG).show();
                }
            }
        });

//        edtTaiKhoan.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String strTaiKhoan = s.toString();
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }
}