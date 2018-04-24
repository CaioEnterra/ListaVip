package com.example.ascom_unitins.listavip.View;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.ascom_unitins.listavip.R;
import com.example.ascom_unitins.listavip.model.Evento;

import java.util.ArrayList;
import java.util.Calendar;

public class TelaCadastroEvento extends AppCompatActivity {

    //Atributos da classe

    EditText nomeEvento = null;
    EditText dataInicio = null;
    EditText dataTermino = null;

    public ArrayList<Evento> eventoList = new ArrayList<Evento>();

    private Button vrBotaoOK = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_evento);

       //Metodo que para pegar dia, mes e ano do calendario (Data de Inicio)
        dataInicio = (EditText) findViewById(R.id.textData_Inicio_Evento);
        dataInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Metodo para o calendario
                Calendar mcurrentTime = Calendar.getInstance();
                int ano = mcurrentTime.get(Calendar.YEAR);
                int mes = mcurrentTime.get(Calendar.MONTH);
                int dia = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mTimePicker;
                mTimePicker = new DatePickerDialog(TelaCadastroEvento.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        //paramentros dos separadores
                        dataInicio.setText(i2+"/"+i1+"/"+i);
                    }

                },ano,mes,dia);
                mTimePicker.setTitle("Selecione a data");
                mTimePicker.show();
            }
        });

        dataTermino = (EditText) findViewById(R.id.dataTermino);
        dataTermino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentTime = Calendar.getInstance();
                int ano = mcurrentTime.get(Calendar.YEAR);
                int mes = mcurrentTime.get(Calendar.MONTH);
                int dia = mcurrentTime.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog mTimePicker;
                mTimePicker = new DatePickerDialog(TelaCadastroEvento.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dataTermino.setText(i2+"/"+i1+"/"+i);
                    }

                },ano,mes,dia);
                mTimePicker.setTitle("Selecione a data");
                mTimePicker.show();
            }
        });

        vrBotaoOK = (Button) findViewById(R.id.botaoOK);
        vrBotaoOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrar();
            }
        });

    }

    public void cadastrar(){
        Evento evento = new Evento();
        nomeEvento = (EditText) findViewById(R.id.textNome_Evento);

        evento.setDataInicio(dataInicio.getText().toString());
        evento.setNome(nomeEvento.getText().toString());
        evento.setDataFim(dataTermino.getText().toString());

        Intent intent = new Intent(TelaCadastroEvento.this,  TelaCadastroPessoas.class);
                startActivity(intent);

        eventoList.add(evento);
    }

    public ArrayList<Evento> retorna(){

        return eventoList;
    }



}



