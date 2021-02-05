package com.example.minhasorte

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class NumerosGeradosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.numeros_gerados)

        val nums = mutableListOf(1)

        runBlocking {
            val job: Job = launch(context = Dispatchers.Default) {
                for (i in 2..60) {
                    nums.add(i)
                }
            }
            job.join()
        }
        //mistura lista
        nums.shuffle()

        val extras = intent.extras
        val tipo = extras!!.getString("MESSAGE2")
        val ano = extras!!.getString("MESSAGE3")
        var anoInt = ano!!.toInt()


        val textView = findViewById<TextView>(R.id.textview4)
        var aposta : String = ""

        when(tipo) {
            "1" -> aposta = (nums[anoInt%60-6]).toString() + " " + (nums[anoInt%60-4]).toString() + " " + (nums[anoInt%60-3]).toString() +  " " + (nums[anoInt%60-2]).toString() + " " + (nums[anoInt%60-1]).toString() + " " + (nums[anoInt%60]).toString()
            "2" -> aposta = (nums[anoInt%60-4]).toString() + " " + (nums[anoInt%60-3]).toString() +  " " + (nums[anoInt%60-2]).toString() + " " + (nums[anoInt%60-1]).toString() + " " + (nums[anoInt%60]).toString()
            else -> {
                aposta = "Inválido"
            }
        }
        textView.text = aposta





    }
}