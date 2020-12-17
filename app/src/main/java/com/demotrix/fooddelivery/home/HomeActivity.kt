package com.demotrix.fooddelivery.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demotrix.fooddelivery.R
import com.demotrix.fooddelivery.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_container, HomeFragment(), HomeFragment.TAG)
            .commit()
    }

    fun showCheckout() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frag_container, CheckoutFragment(), CheckoutFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}