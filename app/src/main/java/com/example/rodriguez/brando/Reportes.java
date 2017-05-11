package com.example.rodriguez.brando;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Reportes extends AppCompatActivity {

    ListView reporte;
    String[] listaOpc;
    Resources res;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        reporte = (ListView)findViewById(R.id.reportes);
        res = getResources();
        listaOpc = res.getStringArray(R.array.reportes);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaOpc);
        reporte.setAdapter(adapter);
        reporte.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent ia = new Intent(Reportes.this, ReporteUno.class);
                        startActivity(ia);
                        break;
                    case 1:
                        Intent ib = new Intent(Reportes.this, ReporteDos.class);
                        startActivity(ib);
                        break;
                    case 2:
                        Intent ic = new Intent(Reportes.this, ReporteTres.class);
                        startActivity(ic);
                        break;
                    case 3:
                        Intent icc = new Intent(Reportes.this, ReporteCuatro.class);
                        startActivity(icc);
                        break;
                    case 4:
                        Intent ie = new Intent(Reportes.this, ReporteCinco.class);
                        startActivity(ie);
                        break;
                    case 5:
                        Intent iee = new Intent(Reportes.this, ReporteSeis.class);
                        startActivity(iee);
                        break;
                }
            }
        });
    }
}
