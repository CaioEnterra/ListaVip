package com.example.ascom_unitins.listavip.model;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ascom_unitins.listavip.R;

public class Pessoa  {

    private String nome;
    private String dataNascimento;
    private String insta;
    private String numero;

    //Construtor
    public Pessoa() {
    }


    public Pessoa(String nome){
        setNome(nome);
    };

    //Metodo get set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

class ItemHolderPessoa extends RecyclerView.ViewHolder {


    TextView confirma = null;


    ItemHolderPessoa(View view){
        super(view);

        confirma = (TextView) view.findViewById(R.id.confirma);



    }
}

