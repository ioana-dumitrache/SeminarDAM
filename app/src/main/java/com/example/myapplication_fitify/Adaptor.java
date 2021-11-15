package com.example.myapplication_fitify;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adaptor extends BaseAdapter {
    private List<Exercitii> listaEx;

    public Adaptor(List<Exercitii> listaEx) {
        this.listaEx=listaEx;
    }
    @Override
    public int getCount() {
        return listaEx.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEx.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.layout_exercitii, parent, false);
        TextView nume=view.findViewById(R.id.textViewDenumire);
        TextView populatie=view.findViewById(R.id.textViewDurata);
        TextView descriere =view.findViewById(R.id.textViewDescriere);

        Exercitii ex=listaEx.get(position);
        nume.setText(ex.getDenumire());
        populatie.setText(ex.getDurata()+"");
        descriere.setText(ex.getDescriere());

        return view;
    }
    public void updateList(List<Exercitii> listaNoua){
        listaEx.addAll(listaNoua);
        notifyDataSetChanged();
    }
}
