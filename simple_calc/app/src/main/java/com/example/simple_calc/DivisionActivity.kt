package com.example.simple_calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivityDivisionBinding

class DivisionActivity : AppCompatActivity() {

    private lateinit var math : Maths
    private lateinit var binding: ActivityDivisionBinding
    private var resultDiv = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDivisionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        this.math = BasicMaths()

        binding.divideButton.setOnClickListener {
            resultDiv= this.math.div(binding.num1.text.toString().toInt(), binding.num2.text.toString().toInt()).toString()
            binding.resultText.setText("${resultDiv}")
        }

        binding.additionOption.setOnClickListener {
            startActivity(this.math.goToSum(this))
            finish()
        }

        binding.subtractionOption.setOnClickListener {
            startActivity(this.math.goToSubtraction(this))
            finish()
        }

        binding.multiplicationOption.setOnClickListener {
            startActivity(this.math.goToMultiplication(this))
            finish()
        }

        binding.divisionOption.setOnClickListener {
            binding.num1.text.clear()
            binding.num2.text.clear()
            binding.resultText.text = ""
        }

        binding.menuButton.setOnClickListener {
            i.putExtra("res", resultDiv)
            setResult(4,i)
            finish()
        }
    }
}