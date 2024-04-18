package com.example.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module1.databinding.ActivityItemDetailsBinding

class ItemDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvEvents.setOnClickListener(ButtonClickListener(this))
        binding.tvTickets.setOnClickListener(ButtonClickListener(this))
        binding.tvRecords.setOnClickListener(ButtonClickListener(this))

    }




}