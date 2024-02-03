package com.example.simple_calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivityMultiplicationBinding

class MultiplicationActivity : AppCompatActivity() {

    private lateinit var math: Maths
    private lateinit var binding: ActivityMultiplicationBinding
    private var resultMult = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultiplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = intent
        this.math = BasicMaths()

        binding.multiplyButton.setOnClickListener {
            resultMult = this.math.mult(binding.num1.text.toString().toInt(), binding.num2.text.toString().toInt()).toString()
            binding.resultText.setText("${resultMult}")
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
            binding.num1.text.clear()
            binding.num2.text.clear()
            binding.resultText.text = ""
        }

        binding.divisionOption.setOnClickListener {
            startActivity(this.math.goToDivision(this))
            finish()
        }

        binding.menuButton.setOnClickListener {
            i.putExtra("res", resultMult)
            setResult(3,i)
            finish()
        }
    }
}