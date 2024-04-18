package com.example.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module1.databinding.ActivityItemDetailsBinding


class DetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityItemDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityItemDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получаем данные из интента
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageId = intent.getIntExtra("imageId", 0)




        val viewCount = SharedPreferencesManager.getViewCount(this)

        // Увеличиваем счетчик на 1 и сохраняем обновленное значение
        SharedPreferencesManager.incrementViewCount(this)

        // Устанавливаем текст с новым значением счетчика
        binding.tvViewCount.text = "Счетчик просмотров: $viewCount"


        // Устанавливаем данные в соответствующие View
        binding.tvTitleDetalish.text = title
        binding.tvDiscriptoinDetalish.text = description
        binding.imPicDetalish1.setImageResource(imageId)

        binding.tvEvents.setOnClickListener(ButtonClickListener(this))
        binding.tvTickets.setOnClickListener(ButtonClickListener(this))
        binding.tvRecords.setOnClickListener(ButtonClickListener(this))



        // Здесь вы можете также добавить обработчик нажатия для каких-либо дополнительных действий, если это необходимо
    }
}

