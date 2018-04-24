package com.example.ascom_unitins.listavip.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ascom_unitins.listavip.model.*;
import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.Evento;

import java.util.ArrayList;

public class TelaListaEvento extends AppCompatActivity {
    ArrayList<Evento> dataSource = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_evento);

       //dataSource = TelaCadastroEvento.retorna();

        //Adicionando fixamente os item, exemplo
        dataSource = new ArrayList<>();
        RecyclerView lista = null;


        dataSource.add(new Evento("CIA"));
        dataSource.add(new Evento("CIA2"));


        lista = (RecyclerView)findViewById(R.id.ListaEvento);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptador adapt = new Adaptador(this, dataSource);
        lista.setAdapter(adapt);

    }
}



