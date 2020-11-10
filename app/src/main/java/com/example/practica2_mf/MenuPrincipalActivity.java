package com.example.practica2_mf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipalActivity extends AppCompatActivity {

    private Button btn_temperatura, btn_conversor, btn_config, btn_cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btn_temperatura = findViewById(R.id.btn_temperatura);
        btn_conversor = findViewById(R.id.btn_conversor);
        btn_config = findViewById(R.id.btn_config);
        btn_cerrar_sesion = findViewById(R.id.btn_cerrar_sesion);

        btn_temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuPrincipalActivity.this, DatosTemperaturaActivity.class));
            }
        });
    }
}