package com.example.simple_calc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.simple_calc.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val optList = ArrayList<String>()

        optList.add("1 Basic Maths")
        optList.add("2 Decimals")
        optList.add("3 Geometrics")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, optList)

        binding.menuList.adapter = adapter

        binding.menuList.setOnItemClickListener{ parent, view, position, id ->
            val mainActivity = Intent(this, MainActivity::class.java)

            if(optList.get(position).contains("1 Basic Maths")){
                startActivity(mainActivity)
            }
        }


    }
}