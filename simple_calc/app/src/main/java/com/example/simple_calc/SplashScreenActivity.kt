package com.example.simple_calc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginButton.setOnClickListener {
<<<<<<< HEAD
            val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
=======
            val menuActivity = Intent(this, MenuActivity::class.java)
            startActivity(menuActivity)
>>>>>>> New_Features
            finish()
        }
    }
}