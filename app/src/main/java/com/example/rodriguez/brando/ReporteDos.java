package com.example.rodriguez.brando;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ReporteDos extends AppCompatActivity {

    private TextView numCarros;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_dos);
        res = getResources();
        numCarros = (TextView)findViewById(R.id.nmarca);


        numCarros.setText(Datos() + "");
    }


    public String Datos(){
        ArrayList<Carro> personas = new ArrayList<>();
        Carro p;
        SQLiteDatabase db;
        String sql,placa,modelo,marca, color, resultado="No hay Carros en la Lista";
        int foto;
        double precio;
        BaseDeDatos psoh = new BaseDeDatos(this);
        db=psoh.getReadableDatabase();
        int mazda =0;
        int chevrolet = 0;
        int renault = 0;

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
                if(marca.equalsIgnoreCase( "Mazda")){
                    mazda = mazda+1;
                }
                if(marca.equalsIgnoreCase("Chevrolet")){
                    chevrolet =chevrolet+ 1;
                }
                if(marca.equalsIgnoreCase( "Renault")){
                    renault =renault+ 1;
                }
                personas.add(p);
            }while(c.moveToNext());
        }
        resultado = "Mazda = "+mazda +"\n"+"Chevrolet = "+chevrolet +"\n"+"Renault = "+renault +"\n";
        return resultado;
    }


}
