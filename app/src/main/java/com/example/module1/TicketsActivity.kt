package com.example.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.view.isInvisible
import com.example.module1.databinding.ActivityTicketsBinding


class TicketsActivity : AppCompatActivity() {

    lateinit var binding: ActivityTicketsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.bCreate.setOnClickListener {
           val intent = Intent(this, CreateTickets::class.java)
           startActivity(intent)}
        val ticketData = intent.getStringExtra("ticketData")
        val category = intent.getStringExtra("category")



        binding.tvTicketData.text = ticketData
        binding.tvCategory.text = category
        if (savedInstanceState != null) {
            val ticketData = savedInstanceState.getString("ticketData")
            val category = savedInstanceState.getString("category")

        }

        binding.cardTickets.setOnClickListener {
            // Открыть подробный экран с билетом (можно реализовать отдельный фрагмент для этого)
            val ticketData = binding.tvTicketData.text.toString()
            val category = binding.tvCategory.text.toString()
            // Открываем подробный экран с билетом, передавая данные
            val intent = Intent(this, CreateTickets::class.java)
            intent.putExtra("ticketData", ticketData)
            intent.putExtra("category", category)
            startActivity(intent)



             fun onSaveInstanceState(outState: Bundle) {
                super.onSaveInstanceState(outState)
                // Сохраняем данные перед уничтожением активити
                outState.putString("ticketData", binding.tvTicketData.text.toString())
                outState.putString("category", binding.tvCategory.text.toString())
            }




             fun updateTicketData(ticketData: String, category: String) {
                binding.tvTicketData.text = ticketData
                binding.tvTicketData.text = category
            }




            //нижняя навигация
            binding.tvEvents.setOnClickListener(ButtonClickListener(this))
            binding.tvTickets.setOnClickListener(ButtonClickListener(this))
            binding.tvRecords.setOnClickListener(ButtonClickListener(this))
            binding.bCreate.setOnClickListener {
                val intent = Intent(this, CreateTickets::class.java)
                startActivity(intent)
            }



        }


    }
}


