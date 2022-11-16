package com.fic.proyectog1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreUsuario, etContrasenia;
    final String MAIN_ACTIVITY_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        Button btnInicioSesion = findViewById(R.id.btnInicioSesion);
        etNombreUsuario = findViewById(R.id.etNombreUsuario);
        etContrasenia = findViewById(R.id.etContrasenia);

        btnInicioSesion.setOnClickListener(accionBotonIniciarSesion);
    }

    public View.OnClickListener accionBotonIniciarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mostrarActividad();
            //mostrarToast(etNombreUsuario.getText().toString());
            escribirLog();
        }
    };

    public void escribirLog(){
        Log.d(MAIN_ACTIVITY_TAG,"Clic en el botón de inicio de sesión");
    }

    public void mostrarToast(String texto){
        Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
    }

    public void mostrarActividad(){
        Intent intencionMostrarActividad = new Intent(getApplicationContext(),HomeActivity.class);
        intencionMostrarActividad.putExtra("nombreUsuario",etNombreUsuario.getText().toString());
        intencionMostrarActividad.putExtra("contraseniaUsuario",etContrasenia.getText().toString());
        startActivity(intencionMostrarActividad);
    }
}