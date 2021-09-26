package com.example.bmi_calculater

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private val et_physical: EditText by lazy {
        findViewById(R.id.et_physical)
    }

    private val et_weigth: EditText by lazy {
        findViewById(R.id.et_weight)
    }

    private val btn_check: Button by lazy {
        findViewById(R.id.btn_check)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_check.setOnClickListener {
            if (et_physical.text.isBlank() || et_weigth.text.isBlank()) {
                Toast.makeText(this, "입력항목이 비어있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val bmi: Double =
                (et_weigth.text.toString().toDouble() / et_physical.text.toString().toDouble()
                    .pow(2)) * 10000

            val intent: Intent = Intent(this, SubActivity::class.java)
            intent.putExtra("BMI", bmi)
            startActivity(intent)

        }


    }

}