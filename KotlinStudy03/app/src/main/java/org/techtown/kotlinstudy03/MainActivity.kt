package org.techtown.kotlinstudy03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.techtown.kotlinstudy03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() ,View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener(this)                //this로 지금 클래스 전달
        binding.minus.setOnClickListener(this)
        binding.multiply.setOnClickListener(this)
        binding.division.setOnClickListener(this)

    }
    fun getOPerator(a:Int , b :Int , op:(Int, Int) -> Int) : Int{
        return op(a,b)
    }

    override fun onClick(view: View?) {
        val sum = { a :Int ,b :Int -> a+b}
        val minus = { a :Int ,b :Int -> a-b}
        val multiply = { a :Int ,b :Int -> a*b}
        val division = { a :Int ,b :Int -> a/b}

        val first = binding.input1.text.toString().toInt()
        val second = binding.input2.text.toString().toInt()
        var result:Int? = null

        when(view){
            binding.add -> {result = getOPerator(first , second,sum)}
            binding.minus ->{result = getOPerator(first , second,minus)}
            binding.multiply ->{result = getOPerator(first , second,multiply)}
            binding.division ->{result = getOPerator(first , second,division)}
        }
        binding.output.text = "결과 : ${result}"
    }

}