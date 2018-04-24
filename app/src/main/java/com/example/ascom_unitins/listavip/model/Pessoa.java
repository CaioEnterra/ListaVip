package com.example.ascom_unitins.listavip;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Pessoa  {

    private String nome;
    private String dataNascimento;
    private String insta;
    private String numero;

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

//metodo que usa recyclerView, usando o chekBox da activity Pessoa
class ItemHolder extends RecyclerView.ViewHolder {


    CheckBox confirma = null;

    ItemHolder(View view){
        super(view);

        confirma = (CheckBox) view.findViewById(R.id.confirma);


    }
}
