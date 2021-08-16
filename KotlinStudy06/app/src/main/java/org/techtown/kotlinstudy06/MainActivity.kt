package org.techtown.kotlinstudy06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.techtown.kotlinstudy06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.save.setOnClickListener {
            val name = binding.inputName.text.toString()
            val age = binding.inputAge.text.toString()

            Toast.makeText(this, "이름 : ${name} , 나이 : ${age}",Toast.LENGTH_SHORT).show()

        }

        binding.exit.setOnClickListener {
            finish()
        }
    }
}