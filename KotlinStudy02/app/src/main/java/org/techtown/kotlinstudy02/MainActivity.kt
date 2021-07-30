package org.techtown.kotlinstudy02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.kotlinstudy02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var one: Int? = null
    var two: Int? = null
    var three: Int? = null
    var four: Int? = null
    var five: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            one = binding.edit1.text.toString().toInt()
            two= binding.edit2.text.toString().toInt()
            three = binding.edit3.text.toString().toInt()
            four = binding.edit4.text.toString().toInt()
            five = binding.edit5.text.toString().toInt()

            var result = one!! + two!! + three!! + four!! + five!!

            binding.text.text = "결과 : ${result}"
        }

    }
}