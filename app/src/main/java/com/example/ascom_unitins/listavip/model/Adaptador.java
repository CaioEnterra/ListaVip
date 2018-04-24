package com.example.ascom_unitins.listavip.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ascom_unitins.listavip.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<ItemHolder>{

    Context contexto = null;
    ArrayList<Evento> lista = null;
    private AlertDialog alerta;

    public Adaptador(Context contexto, ArrayList<Evento> lista){

        this.contexto = contexto;
        this.lista = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */
    //@NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.activity_evento, parent,false );
        ItemHolder item = new ItemHolder(celula);
        return item;
    }
    /*
     * Método que recebe o ViewHolder e a posição da lista.
     * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
     * É onde a mágica acontece!
     * */
    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        Evento item = lista.get(position);

        holder.evento.setText(item.getNome());

        holder.evento.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                contexto = view.getContext();
                Intent intent = new Intent(contexto,Pessoa.class);
                String posicao = Integer.toString(position);
                Log.d("posicao", posicao);
                //intent.putExtra("Nome", lista.get(position).getNome());



                contexto.startActivity(intent);


            }
        });


        holder.evento.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Titulo");
                //define a mensagem
                builder.setMessage("Apagar " + lista.get(position).getNome());
                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        //NetworkUtils.Apagar(lista.get(position));
                        Toast.makeText(contexto, lista.get(position).getNome()+" Apagada", Toast.LENGTH_SHORT).show();
                    }
                });
                //define um botão como negativo.
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });
                //cria o AlertDialog
                alerta = builder.create();
                //Exibe
                alerta.show();
                return true;
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