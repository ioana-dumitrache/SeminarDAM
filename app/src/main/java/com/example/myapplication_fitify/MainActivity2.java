package com.example.myapplication_fitify;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity2 extends AppCompatActivity {
    private Button register;
    private TextInputLayout first, gender, email1, user, pass;
    private String user_firstname, user_gender,user_email, user_username, user_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        first = findViewById(R.id.Firstname);
        gender = findViewById(R.id.Gender);
        email1 = findViewById(R.id.Email);
        user = findViewById(R.id.Username);
        pass = findViewById(R.id.Password);

        register = (Button) findViewById(R.id.buttonRegister);

        user.getEditText().setText(getIntent().getStringExtra("Username"));
        pass.getEditText().setText(getIntent().getStringExtra("Password"));
    }

    public void Metoda_Register(View view) {
        if (!validateFirstName() | !validateGender() | !validateEmail() | !validateUsername() | !validatePasword()) {
            return;
        }
       // String firstname = first.getEditText().getText().toString();
       // String gender = gender.getEditText().getText().toString();
        //String email = email1.getEditText().getText().toString();
        String username = user.getEditText().getText().toString();
        String password = pass.getEditText().getText().toString();
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        intent.putExtra("Username", username);
        intent.putExtra("Password", password);
        startActivity(intent);
    }
    private Boolean validateFirstName() {
        String val = first.getEditText().getText().toString();
        if (val.isEmpty()) {
            first.setError("Write your first name");
            return false;
        } else {
            first.setError(null);
            first.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateGender() {
        String val = gender.getEditText().getText().toString();
        if (val.isEmpty()) {
            gender.setError("Write your gender");
            return false;
        } else {
            gender.setError(null);
            gender.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateEmail() {
        String val = email1.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email1.setError("Write your email");
            return false;
        } else if (!val.matches(emailPattern)) {
            email1.setError("Invalid email address");
            return false;
        } else {
            email1.setError(null);
            email1.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validateUsername() {
        String val = user.getEditText().getText().toString();

        if (val.isEmpty()) {
            user.setError("Write your first name");
            return false;
        } else if (val.length() >= 12) {
            user.setError("Username too long");
            return false;

        } else {
            user.setError(null);
            user.setErrorEnabled(false);
            return true;
        }

    }

    private Boolean validatePasword() {
        String val = pass.getEditText().getText().toString();
        String passwordValue = "^" +
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            pass.setError("Write your password");
            return false;
        } else if (!val.matches(passwordValue)) {
            pass.setError("Password is too weak");
            return false;
        } else {
            pass.setError(null);
            pass.setErrorEnabled(false);
            return true;
        }
    }
}