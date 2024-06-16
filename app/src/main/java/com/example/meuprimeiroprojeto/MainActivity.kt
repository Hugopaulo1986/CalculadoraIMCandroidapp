package com.example.meuprimeiroprojeto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar os componentes do layout
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edittext_peso)
        val edtAltura: EditText = findViewById(R.id.edittext_altura)

        // Configurar o listener do botão calcular
        btnCalcular.setOnClickListener {
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            // Verificar se os campos não estão vazios
            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                try {
                    val altura: Float = alturaStr.toFloat()
                    val peso: Float = pesoStr.toFloat()
                    val alturaFinal: Float = altura * altura
                    val result: Float = peso / alturaFinal

                    // Iniciar a ResultActivity passando o resultado
                    val intent = Intent(this, ResultActivity::class.java).apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                    startActivity(intent)
                } catch (e: NumberFormatException) {
                    // Tratar erros de conversão
                    Toast.makeText(this, "Por favor, insira valores numéricos válidos.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
