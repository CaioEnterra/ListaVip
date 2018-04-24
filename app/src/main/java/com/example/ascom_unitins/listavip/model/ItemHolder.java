package com.example.ascom_unitins.listavip.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ascom_unitins.listavip.R;

/**
 * Created by Ascom_Unitins on 24/04/2018.
 */ //metodo que usa recyclerView, usando o chekBox da activity Pessoa
class ItemHolder extends RecyclerView.ViewHolder {


    TextView confirma = null;
    TextView evento = null;

    ItemHolder(View view){
        super(view);

        confirma = (TextView) view.findViewById(R.id.confirma);
        evento = (TextView) view.findViewById(R.id.NomeEvento);


    }
}
