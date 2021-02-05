package com.example.minhasorte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.minhasorte.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edittext1)
        editText.setInputType(InputType.TYPE_CLASS_NUMBER)
        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener {
            val message = editText.text.toString()
            if(message.isNotEmpty()) {
                sendMessage(it, message)
            }
        }
    }

    private fun sendMessage(view: View, message : String){
        val intent = Intent(this, SelecaoJogo::class.java).apply {
            putExtra("MESSAGE1", message)
        }
        startActivity(intent)
    }
}