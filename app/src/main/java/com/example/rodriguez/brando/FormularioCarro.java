package com.example.rodriguez.brando;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class FormularioCarro extends AppCompatActivity {

    private EditText cajaPlaca,cajaPrecio;
    private Spinner spiMarca, spiModelo, spiColor;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_carro);
        res= getResources();
        cajaPlaca=(EditText)findViewById(R.id.placa);
        cajaPrecio=(EditText)findViewById(R.id.precio);
        spiColor=(Spinner)findViewById(R.id.spColor);
        spiMarca=(Spinner)findViewById(R.id.spMarca);
        spiModelo=(Spinner)findViewById(R.id.spModelo);

        //Rellenar spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaColor));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiColor.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaMarca));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiMarca.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, res.getStringArray(R.array.listaModelo));
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiModelo.setAdapter(adapter3);


    }




    public void cancelar(View v){
        Intent i = new Intent(FormularioCarro.this,MenuPrincipal.class);
        startActivity(i);
    }

    public void guardar(View v){
            if(!cajaPlaca.getText().toString().isEmpty()) {
                if(!cajaPrecio.getText().toString().isEmpty()) {


                    String col = spiColor.getSelectedItem().toString().trim();
                    String pla = cajaPlaca.getText().toString();
                    double pre = Double.parseDouble(cajaPrecio.getText().toString());
                    String mod = spiModelo.getSelectedItem().toString().trim();
                    String mar = spiMarca.getSelectedItem().toString().trim();

                    Carro p = new Carro(foto_aleatoria(), mod, mar, pla,col,pre);
                    p.guardar(this);

                    cajaPrecio.setText("");
                    cajaPlaca.setText("");
                    Toast.makeText(FormularioCarro.this,res.getString(R.string.alerta6), Toast.LENGTH_SHORT).show();



        }else{
                    cajaPrecio.setError(res.getString(R.string.alerta5));
                    cajaPlaca.setError(null);
        }
            }else{
                cajaPlaca.setError(res.getString(R.string.alerta4));
                cajaPrecio.setError(null);
            }



    }

    public int foto_aleatoria(){
        int fotos[]= {R.drawable.images,R.drawable.images2,R.drawable.images3};
        int foto_seleccionada;
        Random r = new Random();
        foto_seleccionada=r.nextInt(3-0);
        return fotos[foto_seleccionada];
    }


    @Override
    public void onBackPressed(){
        Intent i = new Intent(FormularioCarro.this,MenuPrincipal.class);
        startActivity(i);
    }

}
