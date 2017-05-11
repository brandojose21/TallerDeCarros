package com.example.rodriguez.brando;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteTres extends AppCompatActivity {

    private TextView numCarros;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_tres);
        res = getResources();
        numCarros = (TextView)findViewById(R.id.ncolor);


        numCarros.setText(datos() + "");
    }

    public String datos(){
        ArrayList<Carro> personas = new ArrayList<>();
        Carro p;
        SQLiteDatabase db;
        String sql,placa,modelo,marca, color, resultado="No hay Vehiculos Registrados";
        int foto;
        double precio;
        BaseDeDatos psoh = new BaseDeDatos(this);
        db=psoh.getReadableDatabase();
        int negro =0;
        int plateado = 0;
        int blanco = 0;

        sql="Select foto,modelo,marca,placa,color,precio from Carros";
        Cursor c= db.rawQuery(sql, null);

        if(c.moveToFirst()){
            do{
                foto = c.getInt(0);
                modelo=c.getString(1);
                marca=c.getString(2);
                placa=c.getString(3);
                color=c.getString(4);
                precio=c.getDouble(5);
                p= new Carro(foto,modelo,marca,placa, color,precio);
                if(color.equalsIgnoreCase("Blanco") || color.equalsIgnoreCase("White")){
                    blanco = blanco+1;
                }
                if(color.equalsIgnoreCase( "Negro") || color.equalsIgnoreCase("Black")){
                    negro = negro+1;
                }
                if(color.equalsIgnoreCase("Plateado") || color.equalsIgnoreCase( "Silver")){
                    plateado = plateado+1;
                }
                personas.add(p);
            }while(c.moveToNext());
        }
        resultado = "Carros de Color Plateado: "+plateado +"\n"+"Carros de Color Blanco: "+blanco +"\n"+"Carros de Color Negro: "+negro +"\n";
        return resultado;
    }
}
