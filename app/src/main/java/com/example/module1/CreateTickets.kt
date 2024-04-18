package com.example.module1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.module1.databinding.ActivityCreateTicketsBinding



class CreateTickets : AppCompatActivity() {

    lateinit var binding: ActivityCreateTicketsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTicketsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //нижняя навигация
        binding.tvEvents.setOnClickListener(ButtonClickListener(this))
        binding.tvTickets.setOnClickListener(ButtonClickListener(this))
        binding.tvRecords.setOnClickListener(ButtonClickListener(this))
        binding.bTicCreate.setOnClickListener {
            val intent = Intent(this, TicketsActivity::class.java)
            startActivity(intent)
        }


        //Выпадающий список-заполнение
        val spinner = binding.spinner
        val items = arrayOf("Церемония Открытия", "Церемония Закрытия")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        binding.bChoose.setOnClickListener {
            binding.tvChoosePhoto.text = ""
            selectImage()
        }
    }

    // при нажатии на кнопку меняются картинки
    private fun selectImage() {
        val drawableImages = arrayOf(
            R.drawable.circus_icon1,
            R.drawable.concert_icon1,
            R.drawable.cybersport_icon1,
            R.drawable.movie_icon1,
            R.drawable.theatr_icon1
        )

        // Выбираем случайное изображение из списка
        val randomImageId = drawableImages.random()

        // Устанавливаем выбранное изображение в ImageView
        binding.imvChoose.setImageResource(randomImageId)


        binding.bTicCreate.setOnClickListener {
            val intent = Intent(this, TicketsActivity::class.java)
            intent.putExtra("ticketData", binding.edName.text.toString())
            intent.putExtra("category", binding.spinner.selectedItem.toString())
            // Здесь также можно добавить другие данные, которые нужно передать
            startActivity(intent)


        }

    }
}

