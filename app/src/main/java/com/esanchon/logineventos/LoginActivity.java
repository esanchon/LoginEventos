package com.esanchon.logineventos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    EditText user;
    EditText password;
    Button login;
    TextView createAccount;
    TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.et_username_reg);
        password = findViewById(R.id.et_password_reg);
        login = findViewById(R.id.btn_register);
        createAccount = findViewById(R.id.tv_createAcount);
        forgotPassword = findViewById(R.id.tv_forgotPassword);


        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });


        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNew(v);
            }
        });


        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);            }
        });

    }

    private void getNew(View v) {
        //TODO
        Snackbar.make(v, "Soon to be implemented", Snackbar.LENGTH_LONG).show();
    }


    private void attemptLogin() {

        if(TextUtils.isEmpty(password.getText())) {
            password.setError("Este campo es requerido");
        }else if(TextUtils.isEmpty(user.getText())){
            user.setError("Este campo es requerido");
        }else{
            Intent i = new Intent(LoginActivity.this, WelcomeActivity.class);
            i.putExtra("username", user.getText().toString());
            startActivity(i);
        }

    }

}
