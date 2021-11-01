package com.example.myapplication_fitify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
private ArrayList<String> items;
private ArrayAdapter<String> itemsAdapter;
private ListView listView;;
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        listView=findViewById(R.id.listView);
        button=findViewById(R.id.buttonListView);

        button.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items=new ArrayList<>();
        itemsAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
      listView.setAdapter(itemsAdapter);
      setUpListViewListener();
    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {
                Context context=getApplicationContext();
                Toast.makeText(context, "Sters ", Toast.LENGTH_LONG).show();
                items.remove(String.valueOf(i));
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View v) {
        EditText input=findViewById(R.id.editTextListView);
        String itemText=input.getText().toString();

        if(!(itemText.equals("")))
        {
            itemsAdapter.add(itemText);
            input.setText("");
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Completeaza", Toast.LENGTH_LONG).show();
        }
    }
}