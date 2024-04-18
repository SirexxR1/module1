package com.example.module1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.module1.databinding.ListItemBinding
import android.content.Context
import android.content.Intent

class ItemAdapter(private val context: Context) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    enum class Filter {
        ALL, READ, UNREAD
    }

    private val itemList = ArrayList<ItemH>()
    private val filteredItemList = ArrayList<ItemH>()
    private var currentFilter: Filter = Filter.ALL

    // Функция для установки списка элементов
    fun setItems(items: List<ItemH>) {
        itemList.clear()
        itemList.addAll(items)
        filterItems(currentFilter) // Применяем текущий фильтр к новому списку
        notifyDataSetChanged()
    }



    //itemholder
    class ItemHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemH) {
            with(binding) {
                imView.setImageResource(item.imageId)
                tvTitle.text = item.title
                tvDescription.text = item.description

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }


    override fun getItemCount(): Int {
        return filteredItemList.size
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val currentItem = filteredItemList[position]
        holder.bind(currentItem)

        // Установите click listener для открытия DetailsActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", currentItem.title)
            intent.putExtra("description", currentItem.description)
            intent.putExtra("imageId", currentItem.imageId)

            context.startActivity(intent)

            // Увеличите счетчик просмотров текущего элемента
            currentItem.viewCount++

            // Обновите RecyclerView после изменения счетчика просмотров
            notifyItemChanged(position)}



        // Set click listener to open DetailsActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("title", filteredItemList[position].title)
            intent.putExtra("description", filteredItemList[position].description)
            intent.putExtra("imageId", filteredItemList[position].imageId)

            context.startActivity(intent)

            // Установите статус прочитанного элемента
            filteredItemList[position].isRead = true
            notifyDataSetChanged() // Обновите RecyclerView после изменения статуса элемента
            holder.bind(filteredItemList[position])

            context.startActivity(intent)






        }
    }

    fun addItem(imageId: Int, title: String, description: String) {
        val item = ItemH(imageId, title, description,)
        itemList.add(item)
        filterItems(Filter.ALL)
    }


    fun filterItems(filter: Filter) {
        currentFilter = filter
        filteredItemList.clear()
        when (filter) {
            Filter.ALL -> filteredItemList.addAll(itemList)
            Filter.UNREAD -> filteredItemList.addAll(itemList.filter { !it.isRead })
            Filter.READ -> filteredItemList.addAll(itemList.filter { it.isRead })
        }
        notifyDataSetChanged()
    }
}
