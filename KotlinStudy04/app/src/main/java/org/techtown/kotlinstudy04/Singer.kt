package org.techtown.kotlinstudy04

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import org.techtown.kotlinstudy04.databinding.ActivityMainBinding

open class Singer(val name:String? ,val age:Int? ,val binding: ActivityMainBinding) {

  fun showResult(){
      binding.result.text ="결과 : 이름은 ${name} 이고 나이는 ${age}이다"
  }

}