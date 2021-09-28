package org.techtown.kotlinstudy08

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.techtown.kotlinstudy08.databinding.ActivityMainBinding
import org.techtown.kotlinstudy08.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    var _binding : FragmentThirdBinding? = null
    val binding  get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentThirdBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}