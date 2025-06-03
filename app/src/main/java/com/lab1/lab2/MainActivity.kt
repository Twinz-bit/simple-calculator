package com.lab1.lab2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import java.lang.Float

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val number_field_1 = findViewById<EditText>(R.id.number_field_1)
        val number_field_2 = findViewById<EditText>(R.id.number_field_2)
        val button_calculate = findViewById<Button>(R.id.button_calculate)
        val label_text = findViewById<TextView>(R.id.answer)
        val buttonReset = findViewById<Button>(R.id.reset)
        val spinnerOperations = findViewById<Spinner>(R.id.spinnerOperations)

        button_calculate.setOnClickListener {
            val n1 = number_field_1.text.toString().toFloat()
            val n2 = number_field_2.text.toString().toFloat()
            val selectedOperation = spinnerOperations.selectedItem.toString()

            val res = when (selectedOperation) {
                "Сложение" -> n1 + n2
                "Вычитание" -> n1 - n2
                "Умножение" -> n1 * n2
                "Деление" -> if (n2 != 0f) n1 / n2 else "Ошибка: Деление на ноль"
                else -> "Ошибка: Неизвестная операция"
            }

            label_text .text = res.toString()
        }

        buttonReset.setOnClickListener {
            number_field_1.text.clear()
            number_field_2.text.clear()
            label_text.text = "Ответ"
        }

    }
}

