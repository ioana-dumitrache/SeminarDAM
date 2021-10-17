package com.example.myapplication_fitify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void metodaRegister(View view) {
        Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent1);
    }
}