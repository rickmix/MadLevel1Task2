package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var correctAnswers: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomValue()

        binding.btnConfirm.setOnClickListener {
            correctAnswers = 0;
            val input1 = binding.input1.text.toString()
            val input2 = binding.input2.text.toString()
            val input3 = binding.input3.text.toString()
            val input4 = binding.input4.text.toString()
            val value1 = binding.textView5.text.toString()
            val value2 = binding.textView6.text.toString()
            val value3 = binding.textView8.text.toString()
            val value4 = binding.textView9.text.toString()
            val value5 = binding.textView10.text.toString()
            val value6 = binding.textView11.text.toString()
            val value7 = binding.textView12.text.toString()
            val value8 = binding.textView13.text.toString()

            if(checkValues(value1, value2, input1.toLowerCase())) {
                correctAnswers++
            }
            if(checkValues(value3, value4, input2.toLowerCase())) {
                correctAnswers++
            }
            if(checkValues(value5, value6, input3.toLowerCase())) {
                correctAnswers++
            }
            if(checkValues(value7, value8, input4.toLowerCase())) {
                correctAnswers++
            }

            showCorrectAnswers()

            if(correctAnswers == 4) {
                randomValue()
            }

        }
    }

    private fun checkValues(value1: String, value2: String, answer: String): Boolean {

        if(value1 == "T" && value2 == "T") {
            return answer == "t"
        }

        if(value1 == "T" && value2 == "F") {
            return answer == "f"
        }

        if(value1 == "F" && value2 == "T") {
            return answer == "f"
        }

        if(value1 == "F" && value2 == "F") {
            return answer == "f"
        }

        return false
    }

    private fun randomValue() {

        var item: String
        val list: ArrayList<String> = ArrayList()

        for(i in 0..7) {
            val number = (0..1).random()
            item = if(number > 0) {
                "T"
            } else {
                "F"
            }
            list.add(item)
        }

        binding.textView5.text = list[0]
        binding.textView6.text = list[1]
        binding.textView8.text = list[2]
        binding.textView9.text = list[3]
        binding.textView10.text = list[4]
        binding.textView11.text = list[5]
        binding.textView12.text = list[6]
        binding.textView13.text = list[7]
    }

    private fun showCorrectAnswers() {
        Toast.makeText(this, getString(R.string.answer, correctAnswers), Toast.LENGTH_LONG).show()
    }
}