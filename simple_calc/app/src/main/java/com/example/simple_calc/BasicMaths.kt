package com.example.simple_calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class BasicMaths() : Maths {

    init{
        println("Basic Maths Successfully Initialized")
    }

    override fun sum(num1: Int, num2: Int) : Int{
        val result = num1 + num2
        return result
    }

    override fun sub(num1: Int, num2: Int): Int {
        val result = num1 - num2
        return result
    }

    override fun mult(num1: Int, num2: Int) : Int{
        val result = num1 * num2
        return result
    }

    override fun div(num1: Int, num2: Int): Int {
        val result = num1 / num2
        return result
    }

    override fun goToSum(className: AppCompatActivity) : Intent {
        val goTo = Intent(className, SumActivity::class.java)
        return goTo
    }

    override fun goToSubtraction(className: AppCompatActivity) : Intent {
        val goTo = Intent(className, SubtractionActivity::class.java)
        return goTo
    }

    override fun goToMultiplication(className: AppCompatActivity) : Intent {
        val goTo = Intent(className, MultiplicationActivity::class.java)
        return goTo
    }

    override fun goToDivision(className: AppCompatActivity) : Intent {
        val goTo = Intent(className, DivisionActivity::class.java)
        return goTo
    }
}