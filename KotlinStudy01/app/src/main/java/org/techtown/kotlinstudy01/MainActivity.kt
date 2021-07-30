package org.techtown.kotlinstudy01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.kotlinstudy01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.text.text = "입력한 값 : ${binding.edit1.text.toString()}"
        }

        binding.btn2.setOnClickListener {
            binding.text.text = "입력한 값 : ${binding.edit2.text.toString()}"
        }
    }
}