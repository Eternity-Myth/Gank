package com.eternity_myth.gank.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.eternity_myth.gank.MainActivity;
import com.eternity_myth.gank.R;

public class LoginActivity extends AppCompatActivity {
    Button register;
    Button login;
    EditText account;
    EditText password;
    CheckBox remember_pass;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SharedPreferences read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (Button) findViewById(R.id.register);
        login = (Button) findViewById(R.id.login);
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        remember_pass = (CheckBox) findViewById(R.id.remember_pass);
        pref = getSharedPreferences("data", MODE_PRIVATE);
        editor = getSharedPreferences("config", MODE_PRIVATE).edit();
        read = getSharedPreferences("config", MODE_PRIVATE);
        if (!(pref.getString("account", "").equals(""))) {
            account.setText((pref.getString("account", "").toString()));
        }
        if (read.getBoolean("remember_pass", false)) {
            password.setText((pref.getString("password", "").toString()));
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registeractivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registeractivity);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputaccount = account.getText().toString();
                String inputpassword = password.getText().toString();
                String storedaccount = pref.getString("account", "error");
                String storedpassword = pref.getString("password", "error");
                if ((inputaccount.equals(storedaccount)) && (inputpassword.equals(storedpassword))) {
                    if (remember_pass.isChecked()) {
                        editor.putBoolean("remember_pass", true);
                        editor.apply();
                    } else {
                        editor.putBoolean("remember_pass", false);
                        editor.apply();
                    }
                    Toast.makeText(LoginActivity.this, "Success!Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "account or password is invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

