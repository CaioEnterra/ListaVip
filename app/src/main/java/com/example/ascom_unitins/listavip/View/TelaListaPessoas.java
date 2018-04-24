package com.example.ascom_unitins.listavip.View;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.Adaptador;
import com.example.ascom_unitins.listavip.model.Evento;
import com.example.ascom_unitins.listavip.model.Pessoa;


import java.util.ArrayList;


public class TelaListaPessoas extends AppCompatActivity {
    ArrayList<Pessoa> dataSource = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_pessoas);

        //dataSource = TelaCadastroEvento.retorna();

        //Adicionando fixamente os item, exemplo
        dataSource = new ArrayList<>();
        RecyclerView lista = null;


        dataSource.add(new Pessoa("CAIO"));
        dataSource.add(new Pessoa("SCHARLES"));


        lista = (RecyclerView)findViewById(R.id.ListaPessoas);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        //Adaptador adapt = new Adaptador(this, dataSource);
        //lista.setAdapter(adapt);

    }
}