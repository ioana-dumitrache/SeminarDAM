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
    Button salveaza;
    DatabaseReference ref;
    Clase clasa;
    long maxId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        tv1 = (TextView) findViewById(R.id.editTextTip);
        tv2 = (TextView) findViewById(R.id.editTextInstr);
        tv3 = (TextView) findViewById(R.id.editTextData);
        tv4 = (TextView) findViewById(R.id.editTextDen);
        salveaza = (Button) findViewById(R.id.button4);
        clasa = new Clase();
        //ref= FirebaseDatabase.getInstance().getReference().child("Clasa");
        // ref.addValueEventListener(new ValueEventListener() {
        //                              @Override
        //                              public void onDataChange(@NonNull DataSnapshot snapshot) {
        //                                 maxId=(snapshot.getChildrenCount());
        //                             }

        //                            @Override
        //                            public void onCancelled(@NonNull DatabaseError error) {

        //                           }
        //                       });
        salveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clasa.setTip(tv1.getText().toString().trim());
                // clasa.setInstructor(tv2.getText().toString().trim());
                //clasa.setData(tv3.getText().toString().trim());
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
               // ref.child(String.valueOf(maxId + 1)).setValue(clasa);
               // Toast.makeText(MainActivity4.this,"Date inserate",Toast.LENGTH_LONG).show();
            }
        });
    }
}