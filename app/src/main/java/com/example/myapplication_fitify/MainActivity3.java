package com.example.myapplication_fitify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button, button2;
    private Adaptor adaptor;
    private ExercitiiDAO dao;
    private Button clase;
    private JSONReader json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.buttonAdauga);
        button2 = findViewById(R.id.buttonExPropuse);
        clase=findViewById(R.id.buttonVeziClase);
        clase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent4);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(MainActivity3.this, MainActivity5.class);
                startActivity(intent5);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpAdapter();

       // Exercitii ex3=new Exercitii("Triceps",12,"Se folosesc scripetii");
        //Exercitii ex4=new Exercitii("Biceps", 15, "Se folosesc scripetii");

//        dao.insertAll(ex3,ex4);

//        List<Exercitii> lista1=dao.getDurate();
 //       dao.delete(ex3);
  //      List<Exercitii> lista2= dao.getExercitii();

    }
    private void setUpAdapter() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Sters ", Toast.LENGTH_LONG).show();
                items.remove(String.valueOf(i));
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View v) {
        EditText input = findViewById(R.id.editTextListView);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))) {
            itemsAdapter.add(itemText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Completeaza", Toast.LENGTH_LONG).show();
        }
    }
  /*  private List<Exercitii> getLista() {
        ArrayList<Exercitii> lista = new ArrayList<>();
        Exercitii ex1 = new Exercitii("Triceps", 10, "Se folosesc ganterele.");
        Exercitii ex2 = new Exercitii("Piept", 15, "Se foloseste bara olimpica. ");

        lista.add(ex1);
        lista.add(ex2);

        return lista;
    }*/
}