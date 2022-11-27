package com.erdemofset.box

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.erdemofset.box.databinding.ActivityMainBinding
import com.erdemofset.box.ui.*
import com.google.android.material.color.DynamicColors
import com.google.android.material.elevation.SurfaceColors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        DynamicColors.applyIfAvailable(this)
        window.navigationBarColor = SurfaceColors.SURFACE_2.getColor(this)

        replaceFragment(Basic())

        binding.bottom.setOnItemSelectedListener {
            when(it.itemId){
                R.id.basic -> replaceFragment(Basic())
                R.id.deluxe ->replaceFragment(Deluxe())
                R.id.production ->replaceFragment(Production())
                R.id.sales  ->replaceFragment(Sales())
                else ->{
                }
            }
            true
        }
        binding.fab.setOnClickListener {
            replaceFragment(Special())
        }
    }
    private fun replaceFragment (fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}