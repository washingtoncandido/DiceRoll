package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.btnRoll)

        rollButton.setOnClickListener { rollDice() }
        rollDice()

    }

    //Passando um numero aleatorio para dentro do TextView activity_main
    private fun rollDice() {
        //creando o dado
        val myFirstDice: Dice = Dice(6)
        val resultDice = myFirstDice.roll()

        // adicionando a imagem ao layout
        val diceImag: ImageView = findViewById(R.id.ImagDice)

        //Estrutura de repetição usada para troca a imagem de acordo com um numero aleatorio
        val drawableResource = when (myFirstDice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //armazenando a imag dentro da variavel
        diceImag.setImageResource(drawableResource)
        
        //atualizando descrição da imagem
        diceImag.contentDescription = resultDice.toString()
    }
}