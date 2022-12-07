package com.example.agenda;

import androidx.appcompat.app.AlertDialog;
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

    SQLiteDatabase db=null;

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


        criarAbrirDB();
        criarAbrirTabela();
        fecharDB();
    }

    public void criarAbrirDB(){
        try {
            db=openOrCreateDatabase("bancoAgenda",MODE_PRIVATE,null);
        } catch (Exception ex){
            msg("Erro ao criar banco de dados.");
        }
    }
    public void criarAbrirTabela(){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY,nome TEXT,fone TEXT)");
        } catch (Exception ex){
            msg("Erro ao criar tabela.");
        }
    }
    public void fecharDB(){
        db.close();
    }
    public void inserirRegistro(View v){
        String stNome, stTelefone;
        stNome=et_nome.getText().toString();
        stTelefone=et_telefone.getText().toString();
        if(stNome.equals("") || stTelefone.equals("")){
            msg("Todos os campos precisam estar preenchidos.");
            return;
        }
        criarAbrirDB();
        try {
            db.execSQL("INSERT INTO contatos (nome, fone) VALUES ('"+stNome+"','"+stTelefone+"')");
        } catch (Exception ex){
            msg("Erro ao fazer inserção.");
        } finally {
            msg("Contato inserido com sucesso.");
        }
        fecharDB();
        et_nome.setText(null);
        et_telefone.setText(null);
    }
    public void mudarTelaConsulta(View v){
        Intent itTelaConsulta = new Intent(this, TelaConsulta.class);
        startActivity(itTelaConsulta);
    }
    public void fecharTela(View v){
        Intent itFecharTela = new Intent(this, MainActivity.class);
        this.finish();
    }
    public void msg(String v){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage(v);
        adb.setNeutralButton("OK",null);
        adb.show();
    }

}