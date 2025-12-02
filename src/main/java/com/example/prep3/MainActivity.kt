package com.example.prep3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializa os componentes
        val editTextN = findViewById<EditText>(R.id.editTextN)
        val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        // Define o listener do botão
        buttonCalcular.setOnClickListener {
            val inputText = editTextN.text.toString()

            // Validação: verifica se o campo está vazio
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Por favor, insira um número", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val n = inputText.toInt()

                // Validação: n > 0 e n < 6
                if (n <= 0 || n >= 6) {
                    Toast.makeText(this, "O número deve ser maior que 0 e menor que 6", Toast.LENGTH_LONG).show()
                    textViewResultado.text = ""
                    return@setOnClickListener
                }

                // Calcula a série
                val resultado = calcularSerieFactorial(n)

                // Exibe o resultado
                textViewResultado.text = String.format("Resultado: %.6f", resultado)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, insira um número válido", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calcularSerieFactorial(n: Int): Double {
        var soma = 1.0 // Primeiro termo da série: 1

        // Calcula a soma: 1 + 1/1! + 1/2! + 1/3! + ... + 1/n!
        for (i in 1..n) {
            soma += 1.0 / fatorial(i)
        }

        return soma
    }

    private fun fatorial(num: Int): Long {
        if (num == 0 || num == 1) return 1

        var resultado = 1L
        for (i in 2..num) {
            resultado *= i
        }
        return resultado
    }
}