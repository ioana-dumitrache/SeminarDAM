package com.example.myapplication_fitify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    Button buttonRegister;
    private TextInputLayout user, pass;
    private String user_firstname, user_gender,user_email, user_username, user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.Username);
        pass = findViewById(R.id.Password);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

    }

    private Boolean validateUsername() {
        String val = user.getEditText().getText().toString();

        if (val.isEmpty()) {
            user.setError("Write your username");
            return false;
        } else {
            user.setError(null);
            user.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePassword() {
        String val = pass.getEditText().getText().toString();

        if (val.isEmpty()) {
            pass.setError("Write your password");
            return false;

        } else {
            pass.setError(null);
            pass.setErrorEnabled(false);
            return true;
        }
    }

    public void metodaRegister(View view) {
        String username = user.getEditText().getText().toString();
        String password = pass.getEditText().getText().toString();
        User userclass = new User(null, null, null, username, password);
            Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent1);
        finish();
        Toast.makeText(getApplicationContext(), "correct", Toast.LENGTH_LONG).show();

    }

    public void metodaInregistrare(View view) {
        Intent intent3 = new Intent(MainActivity.this, MainActivity3.class);
        startActivity(intent3);
    }
}
