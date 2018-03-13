package com.androiddesdecero.juegomemoria

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cartas_imagen.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var turno: Int = 1
    var puntosPlayer1: Int = 0
    var puntosPlayer2: Int = 0

    var primeraCarta: Int = 0
    var segundaCarta: Int = 0
    var primerClick: Int = 0
    var segundoClick: Int = 0
    var numeroCarta: Int = 1

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
        setUpOnClickListner()

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

    private fun setUpOnClickListner(){
        im11.setOnClickListener(){
            var carta: Int = 0
            asignarImagenalaCarta(im11, carta)
        }

        im12.setOnClickListener(){
            var carta: Int = 1
            asignarImagenalaCarta(im12, carta)
        }

        im13.setOnClickListener(){
            var carta: Int = 2
            asignarImagenalaCarta(im13, carta)
        }

        im21.setOnClickListener(){
            var carta: Int = 3
            asignarImagenalaCarta(im21, carta)
        }

        im22.setOnClickListener(){
            var carta: Int = 4
            asignarImagenalaCarta(im22, carta)
        }

        im23.setOnClickListener(){
            var carta: Int = 5
            asignarImagenalaCarta(im23, carta)
        }

        im31.setOnClickListener(){
            var carta: Int = 6
            asignarImagenalaCarta(im31, carta)
        }

        im32.setOnClickListener(){
            var carta: Int = 7
            asignarImagenalaCarta(im32, carta)
        }

        im33.setOnClickListener(){
            var carta: Int = 8
            asignarImagenalaCarta(im33, carta)
        }

        im41.setOnClickListener(){
            var carta: Int = 9
            asignarImagenalaCarta(im41, carta)
        }
    }

    private fun asignarImagenalaCarta(image: ImageView, carta: Int){
        when(cartas[carta]){
            11 -> image.setImageResource(image11)
            12 -> image.setImageResource(image12)
            13 -> image.setImageResource(image13)
            14 -> image.setImageResource(image14)
            15 -> image.setImageResource(image15)

            21 -> image.setImageResource(image21)
            22 -> image.setImageResource(image22)
            23 -> image.setImageResource(image23)
            24 -> image.setImageResource(image24)
            25 -> image.setImageResource(image25)
        }
        if(numeroCarta == 1) {
            primeraCarta = cartas[carta]
            if (primeraCarta > 20) {
                primeraCarta = primeraCarta - 10
            }
            numeroCarta = 2
            primerClick = carta
            image.isEnabled = false
        }else if(numeroCarta == 2){
            segundaCarta = cartas[carta]
            if (segundaCarta > 20) {
                segundaCarta = segundaCarta - 10
            }
            numeroCarta = 1
            segundoClick = carta

            im11.isEnabled = false
            im12.isEnabled = false
            im13.isEnabled = false
            im21.isEnabled = false
            im22.isEnabled = false
            im23.isEnabled = false
            im31.isEnabled = false
            im32.isEnabled = false
            im33.isEnabled = false
            im41.isEnabled = false

            var handler = Handler()
            handler.postDelayed(Runnable {
                comprobarCorrecto()
            },1000)
        }
    }

    private fun comprobarCorrecto(){
        if(primeraCarta == segundaCarta){
            when(primerClick){
                0 -> im11.visibility = View.INVISIBLE
                1 -> im12.visibility = View.INVISIBLE
                2 -> im13.visibility = View.INVISIBLE
                3 -> im21.visibility = View.INVISIBLE
                4 -> im22.visibility = View.INVISIBLE
                5 -> im23.visibility = View.INVISIBLE
                6 -> im31.visibility = View.INVISIBLE
                7 -> im32.visibility = View.INVISIBLE
                8 -> im33.visibility = View.INVISIBLE
                9 -> im41.visibility = View.INVISIBLE
            }

            when(segundoClick){
                0 -> im11.visibility = View.INVISIBLE
                1 -> im12.visibility = View.INVISIBLE
                2 -> im13.visibility = View.INVISIBLE
                3 -> im21.visibility = View.INVISIBLE
                4 -> im22.visibility = View.INVISIBLE
                5 -> im23.visibility = View.INVISIBLE
                6 -> im31.visibility = View.INVISIBLE
                7 -> im32.visibility = View.INVISIBLE
                8 -> im33.visibility = View.INVISIBLE
                9 -> im41.visibility = View.INVISIBLE
            }

            if(turno == 1){
                puntosPlayer1++
                mainActivityTvPlayer1.setText("Player1: " + puntosPlayer1)
            }else{
                puntosPlayer2++
                mainActivityTvPlayer2.setText("Player2: " + puntosPlayer2)
            }
        }else{
            im11.setImageResource(R.drawable.ic_box_black)
            im12.setImageResource(R.drawable.ic_box_black)
            im13.setImageResource(R.drawable.ic_box_black)

            im21.setImageResource(R.drawable.ic_box_black)
            im22.setImageResource(R.drawable.ic_box_black)
            im23.setImageResource(R.drawable.ic_box_black)

            im31.setImageResource(R.drawable.ic_box_black)
            im32.setImageResource(R.drawable.ic_box_black)
            im33.setImageResource(R.drawable.ic_box_black)

            im41.setImageResource(R.drawable.ic_box_black)

            if(turno == 1){
                turno = 2
                mainActivityTvPlayer1.setTextColor(Color.GRAY)
                mainActivityTvPlayer1.setTypeface(null, Typeface.NORMAL)
                mainActivityTvPlayer2.setTextColor(Color.RED)
                mainActivityTvPlayer2.setTypeface(null, Typeface.BOLD)
            }else{
                turno = 1
                mainActivityTvPlayer1.setTextColor(Color.GREEN)
                mainActivityTvPlayer1.setTypeface(null, Typeface.BOLD)
                mainActivityTvPlayer2.setTextColor(Color.GRAY)
                mainActivityTvPlayer2.setTypeface(null, Typeface.NORMAL)
            }
        }
        im11.isEnabled = true
        im12.isEnabled = true
        im13.isEnabled = true

        im21.isEnabled = true
        im22.isEnabled = true
        im23.isEnabled = true

        im31.isEnabled = true
        im32.isEnabled = true
        im33.isEnabled = true

        im41.isEnabled = true

        finPartida()
    }

    private fun finPartida(){
        if(im11.visibility == View.INVISIBLE &&
                im12.visibility == View.INVISIBLE &&
                im13.visibility == View.INVISIBLE &&
                im21.visibility == View.INVISIBLE &&
                im22.visibility == View.INVISIBLE &&
                im23.visibility == View.INVISIBLE &&
                im31.visibility == View.INVISIBLE &&
                im32.visibility == View.INVISIBLE &&
                im33.visibility == View.INVISIBLE &&
                im41.visibility == View.INVISIBLE){
            var alertDialog = AlertDialog.Builder(this@MainActivity).create()
            alertDialog.setTitle("Fin de Partida")
            alertDialog.setMessage("Player 1: " + puntosPlayer1 + "\nPlayer 2: " + puntosPlayer2)
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){
                dialogInterface, i ->
                var intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            alertDialog.show()
        }
    }


}
