package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.database.sqlite.SQLiteDatabase;//import do banco de dados
import android.database.Cursor;//navegar entre os registros
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    EditText et_nome, et_telefone;
    Button btn_gravar,btn_fechar,btn_consultar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nome         =findViewById(R.id.et_nome);
        et_telefone     =findViewById(R.id.et_telefone);
        btn_consultar   =findViewById(R.id.btn_consultar);
        btn_fechar      =findViewById(R.id.btn_fechar);
        btn_gravar      =findViewById(R.id.btn_gravar);

        Banco.criarAbrirDB(this);
        Banco.criarAbrirTabela(this);
        Banco.fecharDB();
    }

    public void mudarTelaConsulta(View v){
        Intent itTelaConsulta = new Intent(this, TelaConsulta.class);
        startActivity(itTelaConsulta);
    }
    public void fecharTela(View v){
        Intent itFecharTela = new Intent(this, MainActivity.class);
        this.finish();
    }

    public void inserirRegistro(View v){
        String stNome, stTelefone;
        stNome=et_nome.getText().toString();
        stTelefone=et_telefone.getText().toString();
        if(stNome.equals("") || stTelefone.equals("")){
            MSG.mensagem("Todos os campos precisam estar preenchidos.",this);
            return;
        }
        Banco.inserirRegistro(this,stNome,stTelefone);
        et_nome.setText(null);
        et_telefone.setText(null);
    }

}