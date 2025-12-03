package com.example.prep3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;

public class MainActivity extends ComponentActivity {

    private EditText numeroInput;
    private Button calcularButton;
    private TextView resultadoSoma;
    private TextView resultadoFatorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        numeroInput = findViewById(R.id.numeroInput);
        calcularButton = findViewById(R.id.calcularButton);
        resultadoSoma = findViewById(R.id.resultadoSoma);
        resultadoFatorial = findViewById(R.id.resultadoFatorial);

        calcularButton.setOnClickListener(view -> {
            String texto = numeroInput.getText().toString();

            if (texto.isEmpty()) {
                Toast.makeText(this, "Digite um número!", Toast.LENGTH_SHORT).show();
                return;
            }

            int num = Integer.parseInt(texto);

            long soma = somatorio(num);
            long fat = fatorial(num);

            resultadoSoma.setText("Somatório: " + soma);
            resultadoFatorial.setText("Fatorial: " + fat);
        });
    }

    private long somatorio(int num) {
        long soma = 0;

        for (int i = 1; i <= num; i++) {
            soma += i;
        }

        return soma;
    }

    private long fatorial(int num) {
        if (num == 0 || num == 1) return 1;

        long resultado = 1;

        for (int i = 2; i <= num; i++) {
            resultado *= i;
        }

        return resultado;
    }
}
