package org.techtown.kotlinstudy04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.techtown.kotlinstudy04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Singer1 = Singer("최준혁", 26 ,binding)
        val Singer2 = Singer("이병교", 27 ,binding)

        binding.image1.setOnClickListener {
            Toast.makeText(applicationContext,"이미지1 ", Toast.LENGTH_SHORT).show()
            Singer1.showResult()
        }

        binding.image2.setOnClickListener {
            Toast.makeText(applicationContext,"이미지2 ", Toast.LENGTH_SHORT).show()
            Singer2.showResult()
        }

    }
}