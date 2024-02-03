package com.example.simple_calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

interface Maths {

    fun sum(num1: Int, num2: Int) : Int
    fun sub(num1: Int, num2: Int) : Int
    fun mult(num1: Int, num2: Int) : Int
    fun div(num1: Int, num2: Int) : Int
    fun goToSum(className : AppCompatActivity) : Intent
    fun goToSubtraction(className : AppCompatActivity) : Intent
    fun goToMultiplication(className : AppCompatActivity) : Intent
    fun goToDivision(className : AppCompatActivity) : Intent
}