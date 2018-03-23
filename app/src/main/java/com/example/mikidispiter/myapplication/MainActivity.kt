package com.example.mikidispiter.myapplication

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("create")
    }

    var counter = 0
    var selected = ""
    var cenatemp = 0
    var counter1 = 0
    var counter2 = 0
    var counter3 = 0
    var cenatrs = 0



    fun inc(view: View){
        counter = when (selected){
            "turska" -> ++counter1
            "makiato" -> ++counter2
            "tri" -> ++counter3
            else -> 0
        }
        broj.text = counter.toString()
        price()
    }

    fun dec(view: View){
        if (counter > 0){
        counter = when (selected){
            "turska" -> --counter1
            "makiato" -> --counter2
            "tri" -> --counter3
            else -> 0
        }
        }
        broj.text = counter.toString()
        price()
    }
    fun reset(){
        counter = when(selected){
            "turska" -> counter1
            "makiato" -> counter2
            "tri" -> counter3
            else -> 0
        }
        broj.text = counter.toString()
    }

    fun price(){
        cenatemp = 0
        cenatemp = when (selected){
            "turska" -> 60 *counter1
            "makiato" -> 100 * counter2
            "tri" -> 80 * counter3
            else -> 0
        }
        if (slag.isChecked) cenatemp += (10 * counter)
        if (nesquik.isChecked) cenatemp += (20 * counter)
        cena.text = (cenatemp.toString() + " din")
        turskaText.text = "Turska x " + counter1.toString()
        makiatoText.text = "Makiato x " + counter2.toString()
        triText.text = "tri x " + counter3.toString()

    }

    fun turska(view: View){
        if (selected == "turska") {
            selected = ""
            prazna1.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        else {
            selected = "turska"
            prazna1.setBackgroundColor(Color.parseColor("#444444"))
            prazna2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            prazna3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        reset()
        price()
    }
    fun makiato(view: View){
        if (selected == "makiato") {
            selected = ""
            prazna2.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        else {
            selected = "makiato"
            prazna2.setBackgroundColor(Color.parseColor("#444444"))
            prazna1.setBackgroundColor(Color.parseColor("#FFFFFF"))
            prazna3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        reset()
        price()
    }
    fun tri(view: View){
        if (selected == "tri") {
            selected = ""
            prazna3.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        else {
            selected = "tri"
            prazna3.setBackgroundColor(Color.parseColor("#444444"))
            prazna2.setBackgroundColor(Color.parseColor("#FFFFFF"))
            prazna1.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        reset()
        price()
    }

    fun slag(view: View){
        price()
    }

    fun nesquik(view: View){
        price()
    }

    fun naucet(view: View){
        selected = ""
        counter1 = 0
        counter2 = 0
        counter3 = 0
        reset()
        price()
    }
    fun zakonci(view: View){}
}
