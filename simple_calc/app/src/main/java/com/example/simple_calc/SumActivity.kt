package com.example.simple_calc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivitySumBinding

class SumActivity : AppCompatActivity() {

    private lateinit var math : Maths
    private lateinit var binding: ActivitySumBinding
    private var resultSum = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        this.math = BasicMaths()


        binding.sumButton.setOnClickListener {
            val num1 = binding.num1.text.toString().toInt()
            val num2 = binding.num2.text.toString().toInt()
            resultSum = this.math.sum(num1, num2).toString()
            binding.resultText.setText("${resultSum}")
        }


        binding.additionOption.setOnClickListener {
            binding.num1.text.clear()
            binding.num2.text.clear()
            binding.resultText.text = ""
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
            startActivity(this.math.goToDivision(this))
            finish()
        }

        binding.menuButton.setOnClickListener {
            i.putExtra("res", resultSum)
            setResult(1,i)
            finish()
        }
    }
}