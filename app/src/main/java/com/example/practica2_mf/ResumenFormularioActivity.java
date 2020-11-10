package com.example.practica2_mf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResumenFormularioActivity extends AppCompatActivity {

    private EditText et_nombre, et_apellido, et_temp, et_ciudadR, et_provinciaR;
    private Button btn_temperaturaR, btn_guardar;
    private String tipoTemperatura;
    private int temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_formulario);

        et_nombre = findViewById(R.id.et_nombre);
        et_apellido = findViewById(R.id.et_apellido);
        et_temp = findViewById(R.id.et_temp);
        et_ciudadR = findViewById(R.id.et_ciudadR);
        et_provinciaR = findViewById(R.id.et_provinciaR);
        btn_temperaturaR = findViewById(R.id.btn_temperaturaR);
        btn_guardar = findViewById(R.id.btn_guardar);

        Bundle datos = getIntent().getExtras();

        et_nombre.setText(datos.getString("nombre"));
        et_apellido.setText(datos.getString("apellidos"));
        temperatura = datos.getInt("temperatura");
        et_temp.setText(String.valueOf(temperatura));
        et_ciudadR.setText(datos.getString("ciudad"));
        et_provinciaR.setText(datos.getString("provincia"));
        tipoTemperatura = datos.getString("tipo_temperatura");

        if(tipoTemperatura.equals("Celsius")){
            if(temperatura > 38){
                btn_temperaturaR.setBackgroundColor(Color.RED);
            }
        }else{
            if(temperatura > 100){
                btn_temperaturaR.setBackgroundColor(Color.RED);
            }
        }

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResumenFormularioActivity.this, MenuPrincipalActivity.class));
            }
        });
    }
}