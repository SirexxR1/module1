package com.example.module1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ItemAdapter // Обновляем до lateinit var

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ItemAdapter(this) // Передаем контекст здесь






        binding.tvEvents.setOnClickListener(ButtonClickListener(this))
        binding.tvTickets.setOnClickListener(ButtonClickListener(this))
        binding.tvRecords.setOnClickListener(ButtonClickListener(this))

        adapter.addItem(
            R.drawable.concert_icon1,
            "Платина",
            "Концерт Артиста Платина 19 Августа 2024года."
        )
        adapter.addItem(
            R.drawable.movie_icon1,
            "Интерстеллар",
            "Фильм Кристофера Нолана под названием Интерстеллар"
        )
        adapter.addItem(R.drawable.circus_icon1, "Цирк", "Народный Цирк впервые в Казахстане!")
        adapter.addItem(R.drawable.theatr_icon1, "Театр", "Театр имени Горького - Сказка Гофмана")
        adapter.addItem(
            R.drawable.cybersport_icon1,
            "КиберТурнир",
            "Турнир серии Major по Counter-Strike: Global Offensive."
        )



        // Обновляем RecyclerView, чтобы отразить изменения
        adapter.notifyDataSetChanged()



         fun initRecyclerView() {
            binding.rcView.layoutManager = LinearLayoutManager(this)
            binding.rcView.adapter = adapter
        }
        initRecyclerView()


        binding.tvAll.setOnClickListener {
            adapter.filterItems(ItemAdapter.Filter.ALL)
        }
        binding.tvUnread.setOnClickListener {
            adapter.filterItems(ItemAdapter.Filter.UNREAD)
        }
        binding.tvRead.setOnClickListener {
            adapter.filterItems(ItemAdapter.Filter.READ)
        }


        fun onFilterButtonClick(view: View) {
            val button = view as TextView
            if (button.text == "Не прочитано") {
                button.text = "Прочитано"
                // Можно добавить код для обновления статуса элемента в вашем списке данных
            } else {
                button.text = "Не прочитано"
                // Можно добавить код для обновления статуса элемента в вашем списке данных
            }
        }




    }

}


