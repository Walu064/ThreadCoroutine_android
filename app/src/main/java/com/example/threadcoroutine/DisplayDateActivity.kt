package com.example.threadcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.threadcoroutine.databinding.ActivityMainBinding

class DisplayDateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var displayDateViewModel: DisplayDateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        displayDateViewModel = ViewModelProvider(this)[DisplayDateViewModel::class.java]

        binding.viewModel = displayDateViewModel
        binding.lifecycleOwner = this
    }
}