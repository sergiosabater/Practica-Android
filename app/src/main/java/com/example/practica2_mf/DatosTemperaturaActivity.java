package com.example.practica2_mf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DatosTemperaturaActivity extends AppCompatActivity {

    private EditText et_nombre, et_apellidos, et_temperatura, et_ciudad, et_provincia;
    private RadioButton rdbtn_celsius, rdbtn_fahrenheit;
    private Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_temperatura);

        et_nombre = findViewById(R.id.et_nombre);
        et_apellidos = findViewById(R.id.et_apellidos);
        et_temperatura = findViewById(R.id.et_temperatura);
        et_ciudad = findViewById(R.id.et_ciudad);
        et_provincia = findViewById(R.id.et_provincia);
        rdbtn_celsius = findViewById(R.id.rdbtn_celsius);
        rdbtn_fahrenheit = findViewById(R.id.rdbtn_fahrenheit);
        btn_guardar = findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombre.getText().toString();
                String apellido = et_apellidos.getText().toString();

                int temperatura;

                try{
                    temperatura = Integer.parseInt(et_temperatura.getText().toString());
                }catch(NumberFormatException e){
                    temperatura = 0;
                }


                String ciudad = et_ciudad.getText().toString();
                String provincia = et_provincia.getText().toString();

                String tipo_temperatura;

                if(rdbtn_celsius.isChecked()){
                    tipo_temperatura = "Celsius";
                }else{
                    tipo_temperatura = "Fahrenheit";
                }

                if(nombre.isEmpty() || apellido.isEmpty() || temperatura == 0 || ciudad.isEmpty() || provincia.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debe introducir todos los datos", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(DatosTemperaturaActivity.this, ResumenFormularioActivity.class);
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("apellidos", apellido);
                    intent.putExtra("temperatura", temperatura);
                    intent.putExtra("ciudad", ciudad);
                    intent.putExtra("provincia", provincia);
                    intent.putExtra("tipo_temperatura", tipo_temperatura);
                    startActivity(intent);
                }

            }
        });


    }
}