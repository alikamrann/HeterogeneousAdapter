package com.example.heterogeneousadapter.recyclerview.model

interface Item {
    val username: String
    val viewType: Int
}

data class ItemWithImage(override val username: String, val imageUrl: String) : Item {
    override val viewType: Int = VIEW_TYPE_IMAGE
}

data class ItemWithDescription(override val username: String, val description: String) : Item {
    override val viewType: Int = VIEW_TYPE_TEXT
}

const val VIEW_TYPE_IMAGE = 1
const val VIEW_TYPE_TEXT = 2
