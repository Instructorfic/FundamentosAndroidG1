package com.fic.proyectog1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    final String HOME_ACTIVITY_TAG = HomeActivity.class.getSimpleName();
    Button btnVisualizarSitioWeb,btnMarcarNumero, btnVisualizarConfiguracionInalambrica;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnVisualizarSitioWeb = findViewById(R.id.btnVisualizarSitioWeb);
        btnMarcarNumero = findViewById(R.id.btnMarcarNumero);
        btnVisualizarConfiguracionInalambrica = findViewById(R.id.btnVisualizarConfiguracionInalambrica);

        btnVisualizarSitioWeb.setOnClickListener(accionVisualizarSitioWeb);
        btnMarcarNumero.setOnClickListener(accionMarcarNumero);
        btnVisualizarConfiguracionInalambrica.setOnClickListener(accionVisualizarConfiguracionInalambrica);

        //Obtener datos enviados mediante una intención
        Intent obtenerDatosIntencion = getIntent();

        //Único dato
        Log.i(HOME_ACTIVITY_TAG, obtenerDatosIntencion.getData().toString());

        //Extras para extracción de datos
        Log.i(HOME_ACTIVITY_TAG,obtenerDatosIntencion.getStringExtra("nombreUsuario"));
        Log.i(HOME_ACTIVITY_TAG,obtenerDatosIntencion.getStringExtra("contraseniaUsuario"));

        //Bundle para extracción de datos
        Bundle datos = obtenerDatosIntencion.getExtras();
        Log.i(HOME_ACTIVITY_TAG,datos.getString("materia"));
        Log.i(HOME_ACTIVITY_TAG, String.valueOf(datos.getDouble("calificacion")));


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

    public View.OnClickListener accionVisualizarConfiguracionInalambrica = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mostrarConfiguracionRedInalambrica();
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

    public void mostrarConfiguracionRedInalambrica(){
        Intent intencionInalambrica = new Intent(Settings.ACTION_WIFI_SETTINGS);
        startActivity(intencionInalambrica);
    }
}