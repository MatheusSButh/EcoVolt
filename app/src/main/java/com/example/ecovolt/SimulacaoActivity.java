package com.example.ecovolt;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

public class SimulacaoActivity extends AppCompatActivity {

    private EditText editTextGastoAtual;
    private Button buttonSimularSolar;
    private TextView textViewResultadoSolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulacao);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Simulação Solar");
        }

        editTextGastoAtual = findViewById(R.id.editTextGastoAtual);
        buttonSimularSolar = findViewById(R.id.buttonSimularSolar);
        textViewResultadoSolar = findViewById(R.id.textViewResultadoSolar);

        buttonSimularSolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simularEconomia();
            }
        });
    }

    private void simularEconomia() {
        String strGasto = editTextGastoAtual.getText().toString();
        if (strGasto.isEmpty()) return;

        try {
            double gastoAtual = Double.parseDouble(strGasto);




            double custoMinimo = gastoAtual * 0.10; // Taxa
            double economia = gastoAtual * 0.90; // Economia

            NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            String economiaFormatada = formatador.format(economia);
            String novoCustoFormatado = formatador.format(custoMinimo);

            String resultado = String.format(
                    "Economia Potencial: %s/mês\nSua nova fatura estimada: %s/mês",
                    economiaFormatada,
                    novoCustoFormatado
            );
            textViewResultadoSolar.setText(resultado);

        } catch (NumberFormatException e) {

        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}