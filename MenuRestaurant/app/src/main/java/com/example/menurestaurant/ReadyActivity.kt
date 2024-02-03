package com.example.menurestaurant

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.menurestaurant.databinding.ActivityReadyBinding

class ReadyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val orderActivity = Intent(this, OrderActivity::class.java)
            orderActivity.putExtras(i.extras!!)
            startActivity(orderActivity)
            finish()
        }, 3000)
    }
}