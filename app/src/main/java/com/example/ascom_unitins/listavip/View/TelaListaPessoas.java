package com.example.ascom_unitins.listavip.View;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.AdaptadorPessoa;
import com.example.ascom_unitins.listavip.model.Pessoa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


public class TelaListaPessoas extends AppCompatActivity {
    ArrayList<Pessoa> dataSource = null;
    String nomeEvento;

    FloatingActionButton botaoAdd = null;

    private DatabaseReference mDatabase;
    Context minhaActivity =null;
    CheckBox check = null;
    Pessoa pessoaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lista_pessoas);

        Bundle parametros = getIntent().getExtras();
        if(parametros!=null)
        {
            nomeEvento = parametros.getString("NomeEvento");
        }
        botaoAdd = (FloatingActionButton) findViewById(R.id.btnNovaPessoa);
        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context contexto = v.getContext();
                Intent intent = new Intent(contexto, TelaCadastroPessoas.class);
                intent.putExtra("NomeEvento", nomeEvento);

              contexto.startActivity(intent);
            }
        });

        mDatabase = FirebaseDatabase.getInstance().getReference();
        minhaActivity = this;
        check = (CheckBox) findViewById(R.id.checkBoxPresenca);

        //Adicionando fixamente os item, exemplo
        dataSource = new ArrayList<Pessoa>();
        RecyclerView lista = null;

        mostra();
    }


        public void mostra() {

            //dataSource = TelaCadastroEvento.retorna();

            //Adicionando fixamente os item, exemplo
            dataSource = new ArrayList<>();
            RecyclerView lista = null;
            Pessoa pessoaSelecionada;
            //String Nome = this.getIntent().getStringExtra("Nome");





            lista = (RecyclerView)findViewById(R.id.ListaPes);
            lista.setLayoutManager(new LinearLayoutManager(this));
            lista.setItemAnimator(new DefaultItemAnimator());
            lista.setHasFixedSize(true);


            final RecyclerView finalLista = lista;
            mDatabase.child("PessoaDB").addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for(DataSnapshot objSnapShot: dataSnapshot.getChildren()){


                                Pessoa pessoa = objSnapShot.getValue(Pessoa.class);
                                pessoa.setId(objSnapShot.getKey());
                                if(pessoa.getNome_evento().equals(nomeEvento))
                                    dataSource.add(pessoa);

                                Log.i("TAG","");

                            }

                            AdaptadorPessoa adapt = new AdaptadorPessoa(minhaActivity, dataSource, check);
                            adapt.notifyDataSetChanged();
                            finalLista.setAdapter(adapt);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.i("LOG", String.valueOf(databaseError));
//handle databaseError
                        }



                    });

           // AdaptadorPessoa adapt = new AdaptadorPessoa(this, dataSource);
            //lista.setAdapter(adapt);



    }


}


