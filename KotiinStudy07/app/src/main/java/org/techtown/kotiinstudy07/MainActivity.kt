package org.techtown.kotiinstudy07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.kotiinstudy07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val adapter = MusicAdapter()

        binding.register.setOnClickListener {
            val title = binding.title.text.toString()
            val singer = binding.singer.text.toString()
            adapter.items.add(Music(title,singer))
            adapter.notifyDataSetChanged()          //추가 해준 뒤 새로고침
        }

        binding.recyclerView.adapter = adapter
    }


}