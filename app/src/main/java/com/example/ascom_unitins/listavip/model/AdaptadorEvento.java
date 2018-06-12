package com.example.ascom_unitins.listavip.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.View.TelaListaEvento;
import com.example.ascom_unitins.listavip.View.TelaListaPessoas;

import java.util.ArrayList;

public class AdaptadorEvento extends RecyclerView.Adapter<ItemHolderEvento>{

    Context contexto = null;
    ArrayList<Evento> lista = null;
    private AlertDialog alerta;

    public AdaptadorEvento(Context contexto, ArrayList<Evento> lista){

        this.contexto = contexto;
        this.lista = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */

    //@NonNull
    @Override
    public ItemHolderEvento onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.activity_evento, parent,false );
        ItemHolderEvento item = new ItemHolderEvento(celula);
        return item;
    }
    /*
     * Método que recebe o ViewHolder e a posição da lista.
     * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
     * É onde a mágica acontece!
     * */
    @Override
    public void onBindViewHolder(@NonNull ItemHolderEvento holder, final int position) {
        Evento item = lista.get(position);

        holder.evento.setText(item.getNome());
        holder.DataInicio.setText(item.getDataInicio());
        holder.DataFinal.setText(item.getDataFim());

        final Bundle parametros = new Bundle();
        parametros.putString("NomeEvento", item.getNome());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                contexto = view.getContext();
                Intent intent = new Intent(contexto,TelaListaPessoas.class);
                intent.putExtras(parametros);
                contexto.startActivity(intent);


            }
        });




    }


    //METODO QUE DETERMINA QUANTOS ITENS VAI TER NA LISTA
    /*
     * Método que deverá retornar quantos itens há na lista.
     * Aconselha-se verificar se a lista não está nula como no exemplo,
     * pois ao tentar recuperar a quantidade da lista nula pode gerar
     * um erro em tempo de execução (NullPointerException).
     * */
    @Override
    public int getItemCount() {

        return (lista != null)? lista.size() : 0;
    }


}