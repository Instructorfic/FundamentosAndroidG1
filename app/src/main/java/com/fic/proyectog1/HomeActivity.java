package com.fic.proyectog1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnVisualizarSitioWeb,btnMarcarNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnVisualizarSitioWeb = findViewById(R.id.btnVisualizarSitioWeb);
        btnMarcarNumero = findViewById(R.id.btnMarcarNumero);

        btnVisualizarSitioWeb.setOnClickListener(accionVisualizarSitioWeb);
        btnMarcarNumero.setOnClickListener(accionMarcarNumero);
    }

    public View.OnClickListener accionVisualizarSitioWeb = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            visualizarSitioWeb("http://fic.uas.edu.mx");
        }
    };

    public View.OnClickListener accionMarcarNumero = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            marcarNumero("6671000000");
        }
    };

    public void visualizarSitioWeb(String sitioWeb){
        Uri uri = Uri.parse(sitioWeb);
        Intent intencionVisualizarSitioWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intencionVisualizarSitioWeb);
    }

    public void marcarNumero(String numeroTelefono){
        Uri uri = Uri.parse("tel:" + numeroTelefono);
        Intent intencionMarcarNumero = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intencionMarcarNumero);
    }
}