package com.example.shop.domain.model

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    val image: String,
    val rating: Double = 0.0
)

data class CartItem(
    val productId: String,
    val title: String,
    val price: Double,
    val imageUrl: String,
    val quantity: Int
)

data class User(
    val id: String,
    val email: String,
    val name: String,
    val profileImage: String? = null
)

data class Order(
    val id: String,
    val items: List<CartItem>,
    val totalAmount: Double,
    val timestamp: Long,
    val status: String
)
