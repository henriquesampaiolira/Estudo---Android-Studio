package com.example.aula_08;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        //instanciando objeto da classe intent para receber os parametros da outra tela
        Intent it=getIntent();
        //criando a variavel para armazenar o parametro que nesse caso é um double
        //e no caso do double é pedido um valor padrão além do nome do parametro
        double vtotal = it.getDoubleExtra("vtotal",0);
        String nome = it.getStringExtra("nome");
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv = findViewById(R.id.tv1);
        tv.setText(nome +" | " + vtotal);
    }

    public void voltar_Tela(View v) {
        //instanciando um objeto da classe intent, passando a tela como parametro e startando ela para fazer a troca de tela
        Intent it_mudar = new Intent(this, MainActivity.class);
        it_mudar.putExtra("nome", "-"); //-- utilizado para puxar informações passadas atraves do Extra
        startActivity(it_mudar);

        //processo correto de voltar para a tela anterior e sem perder os dados
        this.finish();

    }
}