package org.techtown.kotlinstudy08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import org.techtown.kotlinstudy08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerlayout , binding.toolbar , R.string.open , R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.pager.adapter = ViewPagerAdapter(this)
        binding.pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.pager.offscreenPageLimit = 3

        binding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                //스와이프했을 시 바텀네비게이션도 선택되게함
                binding.bottomnavigation.menu.getItem(position).isChecked = true
            }
        })

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                    R.id.item1 -> {
                        binding.pager.currentItem = 0
                    }
                    R.id.item2 -> {
                        binding.pager.currentItem = 1
                    }
                    R.id.item3 -> {
                        binding.pager.currentItem = 2
                    }
                }
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true

        }

        binding.bottomnavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.tab1->{
                    binding.pager.currentItem = 0
                }
                R.id.tab2->{
                    binding.pager.currentItem = 1
                }
                R.id.tab3 ->{
                    binding.pager.currentItem = 2
                }
            }

            return@setOnItemSelectedListener true
        }


    }

    inner class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0->{
                    FirstFragment()
                }
                1->{
                    SecondFragment()
                }
                2->{
                    ThirdFragment()
                }
                else->{
                    FirstFragment()
                }
            }
        }
    }

    override fun onBackPressed() {
        if(binding.drawerlayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }else {
            super.onBackPressed()
        }
    }
}