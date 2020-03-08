package com.yashdesai.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    EditText edt_first_name,edt_last_name,edt_password,edt_email,edt_banner,edt_dob,edt_last_order;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edt_first_name=(EditText)findViewById(R.id.edt_first_name);
        edt_last_name=(EditText)findViewById(R.id.edt_last_name);
        edt_password=(EditText)findViewById(R.id.edt_password);
        edt_email=(EditText)findViewById(R.id.edt_email);
        edt_banner=(EditText)findViewById(R.id.edt_banner);
        edt_dob=(EditText)findViewById(R.id.edt_dob);
        edt_last_order=(EditText)findViewById(R.id.edt_last_order);
        btn_register=(Button)findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignUp.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
