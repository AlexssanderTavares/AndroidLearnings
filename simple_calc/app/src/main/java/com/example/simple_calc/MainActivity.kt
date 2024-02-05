package com.example.simple_calc

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultSum: ActivityResultLauncher<Intent>
    private lateinit var resultSub: ActivityResultLauncher<Intent>
    private lateinit var resultMult: ActivityResultLauncher<Intent>
    private lateinit var resultDiv: ActivityResultLauncher<Intent>
    private var res = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.additionOption.setOnClickListener {
            val sumActivity = Intent(this, SumActivity::class.java)
            sumActivity.putExtra("res", res)
            resultSum.launch(sumActivity)
        }

        binding.subtractionOption.setOnClickListener {
            val subtractionActivity = Intent(this, SubtractionActivity::class.java)
            subtractionActivity.putExtra("res", res)
            resultSub.launch(subtractionActivity)
        }

        binding.multiplicationOption.setOnClickListener {
            val multiplicationActivity = Intent(this, MultiplicationActivity::class.java)
            multiplicationActivity.putExtra("res", res)
            resultMult.launch(multiplicationActivity)

        }

        binding.divisionOption.setOnClickListener {
            val divisionActivity = Intent(this, DivisionActivity::class.java)
            divisionActivity.putExtra("res",res)
            resultDiv.launch(divisionActivity)
        }

        resultSum = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data != null && it.resultCode == 1){
                res = it.data?.getStringExtra("res").toString()
                binding.additionResult.setText("Last addition result: $res")
            }else {
                binding.additionResult.setText("")
            }
        }

        resultSub = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data != null && it.resultCode == 2){
                res = it.data?.getStringExtra("res").toString()
                binding.subtractionResult.setText("Last subtraction result: $res")
            }else {
                binding.subtractionResult.setText("")
            }
        }

        resultMult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data != null && it.resultCode == 3){
                res = it.data?.getStringExtra("res").toString()
                binding.multiplicationResult.setText("Last multiplication result: $res")
            }else {
                binding.multiplicationResult.setText("")
            }
        }

        resultDiv = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.data != null && it.resultCode == 4){
                res = it.data?.getStringExtra("res").toString()
                binding.divisionResult.setText("Last division result: $res")
            }else {
                binding.divisionResult.setText("")
            }
        }

        binding.backToMainButton.setOnClickListener {
            val menuActivity = Intent(this, MenuActivity::class.java)
            startActivity(menuActivity)
            finish()
        }
    }
}