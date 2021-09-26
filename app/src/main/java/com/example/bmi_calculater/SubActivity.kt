package com.example.bmi_calculater

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SubActivity : AppCompatActivity() {

    private val tv_physical: TextView by lazy {
        findViewById(R.id.tv_physical)
    }

    private val tv_weight: TextView by lazy {
        findViewById(R.id.tv_weight)
    }

    private val bmi: Double by lazy {
        intent.getDoubleExtra("BMI", 0.0)
    }

    private lateinit var result: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        result = when {

            bmi >= 35.0 -> "고도 비만"

            bmi >= 30.0 -> "경도 비만"

            bmi >= 25.0 -> "중정도 비만"

            bmi >= 23.0 -> "과체중"

            bmi >= 18.5 -> "정상"

            else -> "저체중"
        }

        tv_physical.text ="BMI수치: ${bmi.toString()}"
        tv_weight.text = "결과: $result"

    }

}