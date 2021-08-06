package org.techtown.kotlinstudy05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.techtown.kotlinstudy05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var car:CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var car_name:String? = null


        binding.newBenz.setOnClickListener {
            car_name = "Benz"
           car = object : CarAdapter(binding.carName.toString()){
                override fun doStart() {
                    binding.result.text = "${car.name}의 doStart 호출됨"
                }

                override fun doRun() {
                    binding.result.text = "${car.name}의 doRun 호출됨"
                }

                override fun doTurn() {
                    binding.result.text = "${car.name}의 doTurn 호출됨"
                }

                override fun doStop() {
                    binding.result.text = "${car.name}의 doStop 호출됨"
                }
            }
        }

        binding.newBmw.setOnClickListener {
            car_name = "BMW"
            car = object : CarAdapter(binding.carName.toString()){
                override fun doStart() {
                    binding.result.text = "${car.name}의 doStart 호출됨"
                }

                override fun doRun() {
                    binding.result.text = "${car.name}의 doRun 호출됨"
                }

                override fun doTurn() {
                    binding.result.text = "${car.name}의 doTurn 호출됨"
                }

                override fun doStop() {
                    binding.result.text = "${car.name}의 doStop 호출됨"
                }
            }
        }

        binding.check.setOnClickListener {
            binding.resultCar.text = "차종 : ${car_name}"
        }

        binding.run.setOnClickListener {
            car.doRun()
        }

        binding.start.setOnClickListener {
            car.doStart()
        }

        binding.stop.setOnClickListener {
            car.doStop()
        }

        binding.turn.setOnClickListener {
            car.doTurn()
        }


    }
}