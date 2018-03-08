package com.androiddesdecero.juegomemoria

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var turno: Int = 1
    var puntosPlayer1: Int = 0
    var puntosPlayer2: Int = 0

    var primeraCarta: Int = 0
    var segundaCarta: Int = 0
    var primerClick: Int = 0
    var segundoClick: Int = 0
    var numeroCarta: Int = 0

    var cartas = ArrayList<Int>(listOf(11,12,13,14,15,21,22,23,24,25))

    var image11: Int = 0
    var image12: Int = 0
    var image13: Int = 0
    var image14: Int = 0
    var image15: Int = 0

    var image21: Int = 0
    var image22: Int = 0
    var image23: Int = 0
    var image24: Int = 0
    var image25: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1.- SetUp Ui
        setUpUi()

        // 2.- Cargar Cartas
        cargarCartas()

        // 3.- Barajar las Cartas
        Collections.shuffle(cartas)

        // 4.- setUp OnClickListener

    }

    private fun setUpUi(){
        mainActivityTvPlayer1.setTextColor(Color.GREEN)
        mainActivityTvPlayer1.setTypeface(null, Typeface.BOLD)
        mainActivityTvPlayer2.setTextColor(Color.GRAY)
        mainActivityTvPlayer2.setTypeface(null, Typeface.NORMAL)
    }

    private fun cargarCartas(){
        image11 = R.drawable.ic_bike
        image12 = R.drawable.ic_boat
        image13 = R.drawable.ic_car
        image14 = R.drawable.ic_flight
        image15 = R.drawable.ic_railway

        image21 = R.drawable.ic_bike
        image22 = R.drawable.ic_boat
        image23 = R.drawable.ic_car
        image24 = R.drawable.ic_flight
        image25 = R.drawable.ic_railway
    }
}
