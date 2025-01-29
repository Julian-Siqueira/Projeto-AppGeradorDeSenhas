package com.example.appgeradordesenha

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgeradordesenha.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val letrasAlfabeto = ('A'..'Z').toList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGerarSenha.setOnClickListener {
            val letras = gerarLetras()
            val numeros = gerarNumeros()
            binding.txtSenha.text = "$letras-$numeros"
        }
    }

    private fun gerarNumeros(): String {
        val numeros = Random.nextInt(1000..9999)
        return numeros.toString()
    }

    private fun gerarLetras(): String {
        val primeiraLetra = letrasAlfabeto.random()
        val segundaLetra = letrasAlfabeto.random()
        return "$primeiraLetra$segundaLetra"
    }
}