package com.example.menurestaurant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.menurestaurant.databinding.ActivityOrderBinding

class OrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent

        val coffeePrice = i.extras?.getDouble("coffeePrice")
        val breadPrice = i.extras?.getDouble("breadPrice")
        val pGateauPrice = i.extras?.getDouble("pGateauPrice")

        val coffeeQuantity = i.extras?.getInt("coffeeQuantity")
        val breadQuantity = i.extras?.getInt("breadQuantity")
        val pGateauQuantity = i.extras?.getInt("pGateauQuantity")

        val totalCoffee = coffeePrice!! * coffeeQuantity!!
        val totalBread = breadPrice!! * breadQuantity!!
        val totalPGateau = pGateauPrice!! * pGateauQuantity!!
        val total = totalCoffee + totalBread + totalPGateau
        binding.coffeeText.setText("R$ ${totalCoffee}")
        binding.breadText.setText("R$ ${totalBread}")
        binding.petitGateauText.setText("R$ ${totalPGateau}")

        binding.totalOrder.setText("R$ ${total}")

        binding.finishOrder.setOnClickListener {
            finish()
        }

        binding.cancelOrder.setOnClickListener {
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }
    }
}