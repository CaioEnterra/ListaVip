package com.example.ascom_unitins.listavip.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.ascom_unitins.listavip.R;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {

    //Atributos de classe
    private Button vrBotaoCadastrodeEvento = null;
    private Button vrBotaoCadastroPessoa = null;
    private Button vrBotaoSobre = null;
    private Button vrBotaoEvento = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //Chama a tela Cadastro Esvento
        vrBotaoCadastrodeEvento = (Button) findViewById(R.id.BotaoCadEvento);
        vrBotaoCadastrodeEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this,  TelaCadastroEvento.class);
                startActivity(intent);
            }
        });
        //Chama a tela Sobre
        vrBotaoSobre = (Button) findViewById(R.id.BotaoSobre);
        vrBotaoSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this,  TelaSobre.class);
                startActivity(intent);
            }
        });
        //Chama a tela dos Eventos
        vrBotaoEvento = (Button) findViewById(R.id.BotaoEvento);
        vrBotaoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TelaPrincipal.this,  TelaListaEvento.class);
                startActivity(intent);
            }
        });


    }

    //Metodo que utiliza o recursoso botão sair
    @Override
    public void onBackPressed()
    {
        // BOTAO VOLTAR DO APARELHO ANDROID - FECHAR PROGRAMA
        System.exit(0); //fecha aplicativo
        return;
    }

    //Metodo criado automaticamente
    @Override
    public void onClick(View view) {

    }



}
