package com.example.myapplication_fitify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    EditText et1, et2, et3, et4;
    Button salveaza, insereaza;
    DatabaseReference ref, ref2;
    Clase clasa;
    long maxId = 0;
    long maxId2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv1 = (TextView) findViewById(R.id.textTip);
        tv2 = (TextView) findViewById(R.id.textInstr);
        tv3 = (TextView) findViewById(R.id.textData);
        tv4 = (TextView) findViewById(R.id.textDen);
        et1=(EditText) findViewById(R.id.editTextTip);
        et2=(EditText) findViewById(R.id.editTextInstr);
        et3=(EditText) findViewById(R.id.editTextData);
        et4=(EditText) findViewById(R.id.editTextDen);

        salveaza = (Button) findViewById(R.id.button4);
        insereaza = (Button) findViewById(R.id.button5);
        clasa = new Clase();

        ref2=FirebaseDatabase.getInstance().getReference().child("Clasa");
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                    maxId2=(snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ref = FirebaseDatabase.getInstance().getReference().child("Clasa");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                maxId = (snapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        insereaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clasa.setTip(et1.getText().toString().trim());
                clasa.setInstructor(et2.getText().toString().trim());
                clasa.setData(et3.getText().toString().trim());
                clasa.setDenumire(et4.getText().toString().trim());
                ref2.child(String.valueOf(maxId2 + 1)).setValue(clasa);
                Toast.makeText(MainActivity4.this, "Date inserate", Toast.LENGTH_LONG).show();
            }
        });

        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // clasa.setTip(tv1.getText().toString().trim());
                // clasa.setInstructor(tv2.getText().toString().trim());
                // clasa.setData(tv3.getText().toString().trim());
                // clasa.setDenumire(tv4.getText().toString().trim());

                ref = FirebaseDatabase.getInstance().getReference().child("Clasa").child("1");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String data = snapshot.child("data").getValue().toString();
                        String den = snapshot.child("denumire").getValue().toString();
                        String instr = snapshot.child("instructor").getValue().toString();
                        String tip = snapshot.child("tip").getValue().toString();
                        tv1.setText(data);
                        tv2.setText(den);
                        tv3.setText(instr);
                        tv4.setText(tip);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                ref.child(String.valueOf(maxId + 1)).setValue(clasa);
                Toast.makeText(MainActivity4.this, "Date salvate", Toast.LENGTH_LONG).show();
            }
        });
    }
}