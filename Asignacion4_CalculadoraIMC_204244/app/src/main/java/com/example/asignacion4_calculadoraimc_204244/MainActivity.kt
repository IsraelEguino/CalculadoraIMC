package com.example.asignacion4_calculadoraimc_204244

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular : Button = findViewById(R.id.button) as Button
        calcular.setOnClickListener(){
            val weight : EditText = findViewById(R.id.txtPeso) as EditText
            val height : EditText = findViewById(R.id.txtEstatura) as EditText
            val resultado : TextView = findViewById(R.id.txtResultado) as TextView
            val clasificacion : TextView = findViewById(R.id.txtClas) as TextView

            if(isFloat(weight.getText().toString()) && isFloat(height.getText().toString())) {
                val res: Float = (weight.getText().toString().toFloat() / (height.getText().toString().toFloat()*height.getText().toString().toFloat()))
                resultado.setText(res.toString())
                tipo(res,clasificacion)
            } else{
                resultado.setText("Error !!!!!")
            }


        }
    }

    fun isFloat(valor: String): Boolean{
        try{
            valor.toFloat()
            return true
        } catch (e: Exception){
            return false
        }
    }

    fun tipo(valor: Float, clas: TextView){
        if(valor<18.5){
            clas.setText("Bajo peso")
            clas.setBackgroundResource(R.color.colorGreenish)
        } else if(valor>=18.5 && valor<25){
            clas.setText("Normal")
            clas.setBackgroundResource(R.color.colorGreen)
        } else if(valor>=25 && valor<30){
            clas.setText("Sobrepeso")
            clas.setBackgroundResource(R.color.colorYellow)
        } else if(valor>=30 && valor<35){
            clas.setText("Obesidad grado 1")
            clas.setBackgroundResource(R.color.colorOrange)
        } else if(valor>=35 && valor<40){
            clas.setText("Obesidad grado 2")
            clas.setBackgroundResource(R.color.colorRed)
        } else{
            clas.setText("Obesidad grado 3")
            clas.setBackgroundResource(R.color.colorBrown)
        }
    }
}