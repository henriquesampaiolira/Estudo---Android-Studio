package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TelaConsulta extends AppCompatActivity {

    EditText et_nome,et_telefone;
    TextView tv_nome,tv_telefone;
    Button btn_retroceder,btn_avancar,btn_voltarTela;

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

    }

    public void fecharTela(View v){
        Intent itFecharTelaConsulta = new Intent(this,TelaConsulta.class);
        this.finish();
    }


}