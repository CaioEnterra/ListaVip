package com.example.ascom_unitins.listavip.model;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ascom_unitins.listavip.R;

public class Pessoa  {

    private String nome;
    private String idade;
    private String insta;
    private String numero;
    private String nome_evento;

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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String dataNascimento) {
        this.idade = dataNascimento;
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

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }


}

