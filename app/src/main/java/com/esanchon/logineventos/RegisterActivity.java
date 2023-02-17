package com.esanchon.logineventos;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    EditText passwordAgain;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = findViewById(R.id.et_username_reg);
        password = findViewById(R.id.et_password_reg);
        register = findViewById(R.id.btn_register);
        passwordAgain = findViewById(R.id.et_password_repeat);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

    }

    private void attemptLogin() {
        if(TextUtils.isEmpty(user.getText())) {
            user.setError("Este campo es requerido");
        }else if(TextUtils.isEmpty(password.getText())){
            password.setError("Este campo es requerido");
        }else if(TextUtils.isEmpty(passwordAgain.getText())){
            passwordAgain.setError("Este campo es requerido");
        }else{
            Intent i = new Intent(RegisterActivity.this, WelcomeActivity.class);
            i.putExtra("username", user.getText().toString());
            startActivity(i);
        }
    }
}
