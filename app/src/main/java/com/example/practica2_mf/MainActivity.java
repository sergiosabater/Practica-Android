package com.example.practica2_mf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_clave;
    private Button btn_guardar;
    private final String NOMBRE = "admin", CLAVE = "admin";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = findViewById(R.id.et_nombre);
        et_clave = findViewById(R.id.et_clave);
        btn_guardar = findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombre.getText().toString();
                String clave = et_clave.getText().toString();

                if(nombre.equals(NOMBRE) && clave.equals(CLAVE)){
                    startActivity(new Intent(MainActivity.this, MenuPrincipalActivity.class));
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario/contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}