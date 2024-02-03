package com.example.menurestaurant

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.menurestaurant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var coffeeQuantity = 0
    private var coffeePrice = 1.00

    private var breadQuantity = 0
    private var breadPrice = 1.50

    private var pGateauQuantity = 0
    private var pGateauPrice = 3.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.checkCoffee.setOnClickListener {
            if (binding.checkCoffee.isChecked()) {
                binding.visibleCoffee.visibility = View.VISIBLE

                this.coffeeQuantity = 1
                binding.coffeeQuant.setText(this.coffeeQuantity.toString())

                binding.priceCoffee.visibility = View.VISIBLE
                binding.priceCoffee.text = "R$ ${coffeePrice.toString()}"
            } else {
                this.coffeeQuantity = 0
                binding.visibleCoffee.visibility = View.GONE
            }
        }

        binding.checkBread.setOnClickListener {
            if (binding.checkBread.isChecked()) {
                binding.visibleBread.visibility = View.VISIBLE

                this.breadQuantity = 1
                binding.breadQuant.setText(this.breadQuantity.toString())

                binding.priceBread.visibility = View.VISIBLE
                binding.priceBread.text = "R$ ${breadPrice.toString()}"
            } else {
                this.breadQuantity = 0
                binding.visibleBread.visibility = View.GONE
            }
        }

        binding.checkPetitGateau.setOnClickListener {
            if (binding.checkPetitGateau.isChecked()) {
                binding.visiblePetitGateau.visibility = View.VISIBLE

                this.pGateauQuantity = 1
                binding.petitGateauQuant.setText(this.pGateauQuantity.toString())

                binding.pricePetitGateau.visibility = View.VISIBLE
                binding.pricePetitGateau.text = "R$ ${pGateauPrice.toString()}"
            } else {
                this.pGateauQuantity = 0
                binding.visiblePetitGateau.visibility = View.GONE
            }
        }



        binding.finishButton.setOnClickListener {
            this.coffeeQuantity = binding.coffeeQuant.text.toString().trim().toInt()
            this.breadQuantity = binding.breadQuant.text.toString().trim().toInt()
            this.pGateauQuantity = binding.petitGateauQuant.text.toString().trim().toInt()

            val readyActivity = Intent(this, ReadyActivity::class.java)
            readyActivity.putExtra("coffeePrice", this.coffeePrice)
            readyActivity.putExtra("breadPrice", this.breadPrice)
            readyActivity.putExtra("pGateauPrice", this.pGateauPrice)
            readyActivity.putExtra("coffeeQuantity", this.coffeeQuantity)
            readyActivity.putExtra("breadQuantity", this.breadQuantity)
            readyActivity.putExtra("pGateauQuantity", this.pGateauQuantity)
            startActivity(readyActivity)
            finish()
        }
    }
}