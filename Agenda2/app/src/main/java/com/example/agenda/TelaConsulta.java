package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaConsulta extends AppCompatActivity {

    EditText et_nome,et_telefone;
    Button btn_retroceder,btn_avancar,btn_voltarTela;

    SQLiteDatabase db=null;
    Cursor cursor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        et_nome         =findViewById(R.id.et_nomeConsulta);
        et_telefone     =findViewById(R.id.et_telefoneConsulta);
        btn_avancar     =findViewById(R.id.btn_avancarConsulta);
        btn_retroceder  =findViewById(R.id.btn_retrocederConsulta);
        btn_voltarTela  =findViewById(R.id.btn_voltarTelaConsulta);

        buscarDados();

    }

    public void criarAbrirDB(){
        try {
            db=openOrCreateDatabase("bancoAgenda",MODE_PRIVATE,null);
        } catch (Exception ex){
            MSG.mensagem("Erro ao navegar.",this);
        }
    }

    public boolean buscarDados(){
        criarAbrirDB();
        cursor=db.query(
                "contatos",
                new String[]{"nome","fone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        if(cursor.getCount()!=0){
            cursor.moveToFirst();
            Banco.mostrarDados(this.et_nome,this.et_telefone,this.cursor);
            return true;
        }else{
            MSG.mensagem("Nenhuma registro encontrado.",this);
            return false;
        }
    }

    public void proxRegis(View v){
        try {
            cursor.moveToNext();
            Banco.mostrarDados(this.et_nome,this.et_telefone,this.cursor);
        } catch (Exception ex){
            if(cursor.isAfterLast()){
                MSG.mensagem("Não existem mais registros.",this);
            }else {
                MSG.mensagem("Erro ao navegar.",this);
            }
        }
    }


    public void anteRegis(View v){
        try {
            cursor.moveToPrevious();
            Banco.mostrarDados(this.et_nome,this.et_telefone,this.cursor);
        } catch (Exception ex){
            if(cursor.isBeforeFirst()){
                MSG.mensagem("Não existem mais registros.",this);
            }else {
                MSG.mensagem("Erro ao navegar.",this);
            }
        }
    }

    public void fecharTela(View v){
        Intent itFecharTelaConsulta = new Intent(this,TelaConsulta.class);
        this.finish();
    }


}