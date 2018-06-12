package com.example.ascom_unitins.listavip.View;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.Pessoa;
import com.example.ascom_unitins.listavip.model.Evento;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class TelaCadastroPessoas extends AppCompatActivity {

    String NomeEvento, DataInicioEvento, DataFimEvento;
    //Atributo do tipo editText que recebe a referencia dos campos do Layout
    EditText NomePessoa, IdadePessoa, InstaPessoa, NumeroPessoa;
    Button vrBotaoCadastraPessoa;

    //atribudo de refencia do banco
    private DatabaseReference mDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_pessoas);


        Bundle parametros = getIntent().getExtras();
        if(parametros!=null)
        {
            NomeEvento = parametros.getString("NomeEvento");
            DataInicioEvento = parametros.getString("DataInicioEvento");
            DataFimEvento = parametros.getString("DataFimEvento");
        }

        NomePessoa = findViewById(R.id.nomePessoa2);
        IdadePessoa = findViewById(R.id.idadePessoa);
        InstaPessoa = findViewById(R.id.userInsta);
        NumeroPessoa = findViewById(R.id.numero);

        vrBotaoCadastraPessoa = findViewById(R.id.Botao_Cadastra_Pessoa);
        vrBotaoCadastraPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });


        //referencia do firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();



    }

    public void cadastrar() {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome_evento(NomeEvento);
        pessoa.setNome(NomePessoa.getText().toString());
        pessoa.setInsta(InstaPessoa.getText().toString());
        pessoa.setIdade(IdadePessoa.getText().toString());
        pessoa.setNumero(NumeroPessoa.getText().toString());


        mDatabase.child("PessoaDB").child(String.valueOf(new Date())).setValue(pessoa);


        Intent intent = new Intent(this, TelaListaPessoas.class);
        intent.putExtra("NomeEvento",NomeEvento );

        this.startActivity(intent);

    }
}
