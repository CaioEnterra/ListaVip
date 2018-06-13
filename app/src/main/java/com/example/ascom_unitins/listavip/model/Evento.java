package com.example.ascom_unitins.listavip.model;

import com.example.ascom_unitins.listavip.model.Pessoa;

import java.util.ArrayList;


public class Evento {

    private String id;
    private String nome;
    private String dataFim;
    private String dataInicio;
    private ArrayList<Pessoa> pessoas;
   //Construtor
    public Evento() {
    }


    public Evento(String nome){

        setNome(nome);
    };




    //Metodo get set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
