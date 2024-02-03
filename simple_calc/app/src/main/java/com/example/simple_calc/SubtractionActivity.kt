package com.example.simple_calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivitySubtractionBinding

class SubtractionActivity : AppCompatActivity() {

    private lateinit var math: Maths
    private lateinit var binding: ActivitySubtractionBinding
    private var resultSub = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubtractionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        this.math = BasicMaths()

        binding.subButton.setOnClickListener {
            resultSub = this.math.sub(binding.num1.text.toString().toInt(), binding.num2.text.toString().toInt()).toString()
            binding.resultText.setText("${resultSub}")
        }

        binding.subtractionOption.setOnClickListener {
            binding.num1.text.clear()
            binding.num2.text.clear()
            binding.resultText.text = ""
        }

        binding.additionOption.setOnClickListener {
            startActivity(this.math.goToSum(this))
            finish()
        }

        binding.multiplicationOption.setOnClickListener {
            startActivity(this.math.goToMultiplication(this))
            finish()
        }

        binding.divisionOption.setOnClickListener {
            startActivity(this.math.goToDivision(this))
            finish()
        }

        binding.menuButton.setOnClickListener {
            i.putExtra("res", resultSub)
            setResult(2,i)
            finish()
        }
    }
}