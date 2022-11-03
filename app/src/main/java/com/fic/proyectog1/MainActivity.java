package com.fic.proyectog1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInicioSesion = findViewById(R.id.btnIniciarSesion);
        EditText etNombreUsuario = findViewById(R.id.etNombreUsuario);
        EditText etContrasenia = findViewById(R.id.etContrasenia);

        btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escribirLog();
            }
        });
    }

    public void escribirLog(){
        Log.d("MainActivity","Clic en el botón de inicio de sesión");
    }
}