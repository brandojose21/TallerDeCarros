package com.example.rodriguez.brando;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {


    private RecyclerView listado;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);



        listado=(RecyclerView)findViewById(R.id.lista);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listado.setLayoutManager(llm);


        adapter = new Adapter(agregarDatos());
        listado.setAdapter(adapter);
    }



    public ArrayList<Carro> agregarDatos(){
        ArrayList<Carro> personas = new ArrayList<>();
        Carro p;
        SQLiteDatabase db;
        String sql,placa,modelo,marca, color;
        int foto;
        double precio;
        BaseDeDatos psoh = new BaseDeDatos(this);
        db=psoh.getReadableDatabase();

        sql="Select foto,modelo,marca,placa,color,precio from Carros";
        Cursor c= db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getInt(0);
                modelo=c.getString(1);
                marca=c.getString(2);
                placa=c.getString(3);
                color=c.getString(4);
                precio=c.getDouble(5);
                p= new Carro(foto,modelo,marca,placa, color,precio);
                personas.add(p);
            }while(c.moveToNext());
        }

        return personas;
    }

}
