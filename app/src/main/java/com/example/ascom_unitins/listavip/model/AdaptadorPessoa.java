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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdaptadorPessoa  extends RecyclerView.Adapter<ItemHolderPessoa> {

    Context contexto = null;
    ArrayList<Pessoa> listaPessoa = null;
    private AlertDialog alerta;
    //atribudo de refencia do banco
    private DatabaseReference mDatabase;
    Pessoa pessoaSelecionada;

    public AdaptadorPessoa(Context contexto, ArrayList<Pessoa> lista) {

        this.contexto = contexto;
        this.listaPessoa = lista;
    }

    //METODO CHAMADO N VEZES PARA INFLAR O XML DA CELULA E RETORNAR UM OBJETO DE LAYOUT
    /* Método que deverá retornar layout criado pelo ViewHolder já inflado em uma view. */
    //@NonNull
    @Override
    public ItemHolderPessoa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.activity_pessoa, parent, false);
        ItemHolderPessoa item = new ItemHolderPessoa(celula);

        //referencia do firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();
        return item;
    }

    /*
     * Método que recebe o ViewHolder e a posição da lista.
     * Aqui é recuperado o objeto da lista de Objetos pela posição e associado à ViewHolder.
     * É onde a mágica acontece!
     * */
    @Override
    public void onBindViewHolder(@NonNull ItemHolderPessoa celula, final int position) {
        Pessoa item = listaPessoa.get(position);

        celula.nome.setText(item.getNome());
        celula.idade.setText(item.getIdade());
        celula.insta.setText(item.getInsta());
        celula.numero.setText(item.getNumero());

        celula.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                contexto = view.getContext();
//                Intent intent = new Intent(contexto,Pessoa.class);
//                String posicao = Integer.toString(position);
//                Log.d("posicao", posicao);
//                //intent.putExtra("Nome", lista.get(position).getNome());


//                contexto.startActivity(intent);


            }
        });


        celula.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Titulo");

                //define a mensagem
                builder.setMessage("Apagar " + listaPessoa.get(position).getNome());

                //define um botão como positivo
                builder.setPositiveButton("Apagar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        //NetworkUtils.Apagar(lista.get(position));
                        Toast.makeText(contexto, listaPessoa.get(position).getNome()
                                + " Deletado", Toast.LENGTH_SHORT).show();
                        pessoaSelecionada = (Pessoa)listaPessoa.get(position);

                        mDatabase.child("PessoaDB").child(pessoaSelecionada.).deleteValue()
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error deleting document", e);
                                    }
                                });

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

        return (listaPessoa != null) ? listaPessoa.size() : 0;
    }


}