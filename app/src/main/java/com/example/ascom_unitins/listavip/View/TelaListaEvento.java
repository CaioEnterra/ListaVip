package com.example.ascom_unitins.listavip.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ascom_unitins.listavip.model.*;
import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.Evento;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TelaListaEvento extends AppCompatActivity {
    ArrayList<Evento> dataSource = null;
    private DatabaseReference mDatabase;
    Context minhaActivity =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_evento);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        minhaActivity = this;

        mostra();


    }

    public static ArrayList<Evento> pega(ArrayList<Evento> vem) {
        ArrayList<Evento> evento = new ArrayList<Evento>();
        evento = vem;
        return evento;
    }

    public static ArrayList<Evento> mostra(ArrayList<Evento> vem) {
        ArrayList<Evento> evento = new ArrayList<Evento>();
        evento = vem;
        return evento;
    }



    public void mostra() {

        //dataSource = TelaCadastroEvento.retorna();

        //Adicionando fixamente os item, exemplo
        dataSource = new ArrayList<>();
        RecyclerView lista = null;
        String Nome = this.getIntent().getStringExtra("Nome");


        lista = (RecyclerView) findViewById(R.id.ListaEvento);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);


        final RecyclerView finalLista = lista;
        mDatabase.child("EventoDB").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for(DataSnapshot objSnapShot: dataSnapshot.getChildren()){


                                Evento evento = objSnapShot.getValue(Evento.class);

                                dataSource.add(evento);

                                Log.i("TAG","");

                        }

                        AdaptadorEvento adapt = new AdaptadorEvento(minhaActivity, dataSource);
                        adapt.notifyDataSetChanged();
                        finalLista.setAdapter(adapt);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("LOG", String.valueOf(databaseError));
//handle databaseError
                    }



                });

        //AdaptadorEvento adapt = new AdaptadorEvento(this, dataSource);
        //lista.setAdapter(adapt);
    }


}



