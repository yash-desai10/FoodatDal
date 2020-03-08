package com.yashdesai.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity
{
    EditText edt_banner,edt_password;
    Button btn_login, btn_new_user;
    TextView tv_forgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_banner=(EditText)findViewById(R.id.edt_banner);
        edt_password=(EditText)findViewById(R.id.edt_password);
        tv_forgot=(TextView)findViewById(R.id.tv_forgot);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_new_user=(Button)findViewById(R.id.btn_new_user);
        tv_forgot=(TextView) findViewById(R.id.tv_forgot);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
