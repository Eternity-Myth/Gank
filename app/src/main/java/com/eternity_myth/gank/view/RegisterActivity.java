package com.eternity_myth.gank.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.eternity_myth.gank.R;

public class RegisterActivity extends AppCompatActivity {
    EditText account, password, confirm;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        account = (EditText) findViewById(R.id.Account);
        password = (EditText) findViewById(R.id.Password);
        confirm = (EditText) findViewById(R.id.Confirm);
        register = (Button) findViewById(R.id.Register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(account.getText().toString().trim(), password.getText().toString().trim(), confirm.getText().toString().trim());
            }
        });
    }

    public void check(String account, String password, String confirm) {
        if (account.equals("")) {
            Toast.makeText(RegisterActivity.this, "Account can not be null!", Toast.LENGTH_SHORT).show();
        } else if (password.equals("")) {
            Toast.makeText(RegisterActivity.this, "Password can not be null!", Toast.LENGTH_SHORT).show();
        } else if (confirm.equals("")) {
            Toast.makeText(RegisterActivity.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
        } else if (!(password.equals(confirm))) {
            Toast.makeText(RegisterActivity.this, "Passwords are not the same!", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
            editor.putString("account", account);
            editor.putString("password", password);
            editor.apply();
            Intent back = new Intent(RegisterActivity.this, LoginActivity.class);
            Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
            startActivity(back);
            finish();
        }
    }
}