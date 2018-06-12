package com.example.ascom_unitins.listavip.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ascom_unitins.listavip.R;

/**
 * Created by Ascom_Unitins on 24/04/2018.
 */ //metodo que usa recyclerView, usando o chekBox da activity Pessoa
class ItemHolderEvento extends RecyclerView.ViewHolder {


    TextView evento = null;
    TextView DataFinal = null;
    TextView DataInicio = null;

    ItemHolderEvento(View view){
        super(view);


        evento = (TextView) view.findViewById(R.id.NomeEvento);
        DataFinal = (TextView) view.findViewById(R.id.DataFinal);
        DataInicio = (TextView) view.findViewById(R.id.DataInicio);



    }
}
