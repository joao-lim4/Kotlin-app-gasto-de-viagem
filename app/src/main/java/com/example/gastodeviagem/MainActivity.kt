package com.example.gastodeviagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.gastodeviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)


        this.binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate) {
            this.calculate()
        }
    }

    private fun isValid(): Boolean {
        return (this.binding.editDistance.text.toString() != ""
                && this.binding.editPrice.text.toString() != ""
                && this.binding.editAutonomie.text.toString() != ""
                && this.binding.editAutonomie.text.toString().toFloat() != 0f)
    }

    @SuppressLint("SetTextI18n")
    private fun calculate() {
        if(this.isValid()) {
            val distance = this.binding.editDistance.text.toString().toFloat()
            val price = this.binding.editPrice.text.toString().toFloat()
            val autonomie = this.binding.editAutonomie.text.toString().toFloat()

            val resultTotalValue = (distance * price) / autonomie

            this.binding.textTotalValue.text = "R$ ${"%.2f".format(resultTotalValue)}";

            Toast.makeText(applicationContext, "O total é: R$ ${"%.2f".format(resultTotalValue)}", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(applicationContext, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show();
        }

    }
}