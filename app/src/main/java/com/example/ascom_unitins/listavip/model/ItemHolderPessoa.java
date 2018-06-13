package com.example.ascom_unitins.listavip.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.ascom_unitins.listavip.R;

/**
 * Created by Ascom_Unitins on 24/04/2018.
 */
public class ItemHolderPessoa extends RecyclerView.ViewHolder {


    public TextView nome ;
    public TextView numero ;
    public TextView insta ;
    public TextView idade ;

    public CheckBox presenca;

    public ItemHolderPessoa(View view) {
        super(view);


        setNome((TextView) view.findViewById(R.id.nomePessoa));
        setIdade((TextView) view.findViewById(R.id.idadePessoa));
        setInsta((TextView) view.findViewById(R.id.instaPessoa));
        setNumero((TextView) view.findViewById(R.id.numeroPessoa));
        setPresenca((CheckBox) view.findViewById(R.id.checkBoxPresenca));


    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getNumero() {
        return numero;
    }

    public void setNumero(TextView numero) {
        this.numero = numero;
    }

    public TextView getInsta() {
        return insta;
    }

    public void setInsta(TextView insta) {
        this.insta = insta;
    }

    public TextView getIdade() {
        return idade;
    }

    public void setIdade(TextView idade) {
        this.idade = idade;
    }

    public CheckBox getPresenca() {
        return presenca;
    }

    public void setPresenca(CheckBox presenca) {
        presenca = presenca;
    }
}
