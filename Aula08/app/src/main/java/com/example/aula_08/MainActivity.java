package com.example.aula_08;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double vteclado,vmouse,vmonitor,vpc,vtotal;
    EditText et_teclado,et_mouse,et_monitor,et_pc;
    TextView res;
    Button btn;
    CheckBox cb_teclado, cb_mouse,cb_monitor,cb_pc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associação dos Edit Text com as variáveis criadas
        et_teclado=findViewById(R.id.et_v1_teclado);
        et_mouse=findViewById(R.id.et_v2_mouse);
        et_monitor=findViewById(R.id.et_v3_monitor);
        et_pc=findViewById(R.id.et_v4_pc);
        // Associação dos check box
        cb_monitor=findViewById(R.id.cb3_monitor);
        cb_pc=findViewById(R.id.cb4_pc);
        cb_mouse=findViewById(R.id.cb2_mouse);
        cb_teclado=findViewById(R.id.cb1_teclado);
        //Valores de cada item individual para fazer o cálculo
        vteclado = 35.5;
        vmouse   = 17.9;
        vmonitor = 899.99;
        vpc      = 3573.23;
        //Associando o botão
        btn = findViewById(R.id.button);
        //Associação do Text View que será o resultado
        res = findViewById(R.id.tv_res);
        //Adicionando valores unitãrios ao lado do item
        cb_teclado.setText(cb_teclado.getText().toString()+vteclado);
        cb_pc.setText(cb_pc.getText().toString()+vpc);
        cb_mouse.setText(cb_mouse.getText().toString()+vmouse);
        cb_monitor.setText(cb_monitor.getText().toString()+vmonitor);
    }
    public void Calcular(View v) {
        res = findViewById(R.id.tv_res);
        vtotal = 0.0;
        if (cb_teclado.isChecked()) {
            vtotal += vteclado * Double.parseDouble(et_teclado.getText().toString());
        }
        if (cb_monitor.isChecked()) {
            vtotal += vmonitor * Double.parseDouble(et_monitor.getText().toString());
        }
        if (cb_pc.isChecked()) {
            vtotal += vpc * Double.parseDouble(et_pc.getText().toString());
        }
        if (cb_mouse.isChecked()) {
            vtotal += vmouse * Double.parseDouble(et_mouse.getText().toString());
        }
        res.setText("Valor total: R$" + vtotal);
        //Utilizando o Toast para criar notificação no aplicativo
        //Toast.makeText(this,"Valor total calculado.",Toast.LENGTH_LONG).show();


        //AlertDialog para criar um outro tipo de notificação
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setMessage("Valor total calculado.");
        ad.setNeutralButton("Ok", null);
        //utilizando setNeutraaButton para gerar
        // um botão clicável ao aparecer a notificação
        ad.show(); //para mostrar a notificação

    }
    public void mudar_tela(View v){
        // instanciando uma intent da classe, passando a tela como parametro e startando ela para fazer a troca de tela
        Intent it_mudar = new Intent(this, Tela2.class);
        //putExtra para passar parâmetros, tem que ser antes do start
        it_mudar.putExtra("vtotal",vtotal);
        it_mudar.putExtra("nome","henryzera");
        startActivity(it_mudar);

        //método para trocar o xml (tela)
        //setContentView(R.layout.activity_tela2);
    }


}





















