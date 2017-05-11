package com.example.rodriguez.brando;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteUno extends AppCompatActivity {

    private TextView numCarros;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_uno);
        res = getResources();
        numCarros = (TextView)findViewById(R.id.ncarros);

        ArrayList<Carro>  lista= listaDatos();
        int resul = lista.size();
        numCarros.setText("Carros Agregados: "+resul+"");
    }

    public ArrayList<Carro> listaDatos(){
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
