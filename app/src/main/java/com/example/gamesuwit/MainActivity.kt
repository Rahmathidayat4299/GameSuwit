package com.example.gamesuwit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var batup1 : ImageView
    lateinit var guntingp1 : ImageView
    lateinit var kertasp1 : ImageView
    lateinit var batuCom : ImageView
    lateinit var kertasCom : ImageView
    lateinit var guntingCom : ImageView
    lateinit var player1 : TextView
    lateinit var tv_com : TextView
    lateinit var tv_VS : TextView
    lateinit var btn_reset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batup1 = findViewById(R.id.batup1)
        guntingp1 = findViewById(R.id.guntingp1)
        kertasp1 = findViewById(R.id.kertasp1)

        batuCom = findViewById(R.id.batuCom)
        kertasCom = findViewById(R.id.kertasCom)
        guntingCom = findViewById(R.id.guntingCom)
        tv_VS = findViewById(R.id.tv_VS)
        btn_reset = findViewById(R.id.btn_reset)


        val playerSatu = arrayOf(batup1,guntingp1,kertasp1)
        val com = arrayOf(batuCom,kertasCom,guntingCom)

        playerSatu.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val pilihanCom= com.random()
                controlGame(playerSatu[index].contentDescription,pilihanCom.contentDescription)
                pilihanCom.setBackgroundResource(R.drawable.bg_image)


                playerSatu.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }

                playerSatu[index].setBackgroundResource(R.drawable.bg_image)

            }




        }

        btn_reset.setOnClickListener {
            tv_VS.text = "VS"
            playerSatu.forEach {
                it.setBackgroundResource(android.R.color.transparent)
            }

            com.forEach {
                it.setBackgroundResource(android.R.color.transparent)
            }

        }



    }

    fun controlGame(playerSatu: CharSequence, com: CharSequence){
        if (playerSatu == com) {
            tv_VS.text = "Draw"
        } else if ((playerSatu == batup1.contentDescription) && (com == guntingCom.contentDescription) || (playerSatu == guntingp1.contentDescription) && (com == kertasCom.contentDescription) || (playerSatu == kertasp1.contentDescription) && (com == batuCom.contentDescription)) {

            tv_VS.text = "Player 1 menang"




        } else {
            tv_VS.text="COM menang"


        }
        Log.d("hasil", "$playerSatu VS $com")


    }
}