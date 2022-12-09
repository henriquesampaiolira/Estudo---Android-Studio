package com.example.agenda;

import static android.content.Context.MODE_PRIVATE;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;


public class Banco {

    static SQLiteDatabase db=null;

    public static void criarAbrirDB(Activity act){
        try {
            ContextWrapper cw = new ContextWrapper(act);
            db=cw.openOrCreateDatabase("bancoAgenda",MODE_PRIVATE,null);
        } catch (Exception ex){
            MSG.mensagem("Erro ao criar banco de dados.",act);
        }

    }

    public static void criarAbrirTabela(Activity act){
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY,nome TEXT,fone TEXT)");
        } catch (Exception ex){
            MSG.mensagem("Erro ao criar tabela.",act);
        }
    }

    public static void fecharDB(){
        db.close();
    }

    static public void inserirRegistro(Activity act, String nome, String fone){
        criarAbrirDB(act);
        try {
            db.execSQL("INSERT INTO contatos (nome, fone) VALUES ('"+nome+"','"+fone+"')");
        } catch (Exception ex){
            MSG.mensagem("Erro ao fazer inserção.",act);
        } finally {
            MSG.mensagem("Contato inserido com sucesso.",act);
        }
        fecharDB();
    }

//    public static void anteRegis(Activity act, Cursor cursor, EditText et_nome, EditText et_telefone){
//        try {
//            cursor.moveToPrevious();
//            mostrarDados(et_nome,et_telefone,cursor);
//        } catch (Exception ex){
//            if(cursor.isBeforeFirst()){
//                MSG.mensagem("Não existem mais registros.",act);
//            }else {
//                MSG.mensagem("Erro ao navegar.",act);
//            }
//        }
//    }
    static public void mostrarDados(EditText et_nome, EditText et_telefone, Cursor cursor){
        et_nome.setText(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        et_telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow("fone")));
    }


}




