package com.example.ecovolt;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPotencia, editTextHoras, editTextPrecoKWh;
    private Button buttonCalcular, buttonDicas, buttonSimulacao;
    private TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextPotencia = findViewById(R.id.editTextPotencia);
        editTextHoras = findViewById(R.id.editTextHoras);
        editTextPrecoKWh = findViewById(R.id.editTextPrecoKWh);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonDicas = findViewById(R.id.buttonDicas);
        buttonSimulacao = findViewById(R.id.buttonSimulacao);


        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularConsumo();
            }
        });


        buttonDicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre a nova tela (Activity) de Dicas
                Intent intent = new Intent(MainActivity.this, DicasActivity.class);
                startActivity(intent);
            }
        });


        buttonSimulacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre a nova tela (Activity) de Simulação
                Intent intent = new Intent(MainActivity.this, SimulacaoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calcularConsumo() {
        String strPotencia = editTextPotencia.getText().toString();
        String strHoras = editTextHoras.getText().toString();
        String strPreco = editTextPrecoKWh.getText().toString();

        if (strPotencia.isEmpty() || strHoras.isEmpty() || strPreco.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos da calculadora", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double potencia = Double.parseDouble(strPotencia);
            double horas = Double.parseDouble(strHoras);
            double precoKWh = Double.parseDouble(strPreco);


            double consumoKWh = (potencia * horas * 30) / 1000.0;
            double custoReais = consumoKWh * precoKWh;

            NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String custoFormatado = formatadorMoeda.format(custoReais);

            String resultado = String.format(
                    "Consumo Mensal: %.2f kWh\nCusto Estimado: %s",
                    consumoKWh,
                    custoFormatado
            );
            textViewResultado.setText(resultado);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores numéricos inválidos", Toast.LENGTH_SHORT).show();
        }
    }
}