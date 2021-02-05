package com.example.minhasorte

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelecaoJogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selecao_jogo)

        val extras = intent.extras
        val ano = extras!!.getString("MESSAGE1")

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            sendMessage(it, "1", ano)
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            sendMessage(it, "2", ano)
        }
    }

    private fun sendMessage(view: View, tipoJogo : String, ano : String?) {
        val intent = Intent(this, NumerosGeradosActivity::class.java).apply {
            putExtra("MESSAGE2", tipoJogo)
            putExtra("MESSAGE3", ano)
        }
        startActivity(intent)
    }


}