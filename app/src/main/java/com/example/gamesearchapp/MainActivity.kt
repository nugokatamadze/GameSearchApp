package com.example.gamesearchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.forEach
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gamesearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setBackgroundDrawableResource(R.drawable.default_background)

    }
    private fun init(){
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.fragmentContainer))

    }
    fun disableNavBar(){
        binding.bottomNavigationView.menu.forEach {
            it.isEnabled=false
        }
    }
    fun enableNavBar(){
        binding.bottomNavigationView.menu.forEach {
            it.isEnabled=true
        }
    }
}