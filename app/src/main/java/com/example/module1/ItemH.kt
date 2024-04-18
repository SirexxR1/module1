package com.example.module1

data class ItemH(
    val imageId: Int,
    val title: String,
    val description: String,
    var isRead: Boolean = false,
    var viewCount: Int = 0
)

