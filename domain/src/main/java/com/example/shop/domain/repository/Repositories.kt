package com.example.shop.domain.repository

import com.example.shop.domain.model.CartItem
import com.example.shop.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Result<List<Product>>
    suspend fun getProductById(id: String): Result<Product>
    suspend fun getCategories(): Result<List<String>>
}

interface CartRepository {
    fun getCartItems(): Flow<List<CartItem>>
    suspend fun addToCart(item: CartItem)
    suspend fun removeFromCart(productId: String)
    suspend fun updateQuantity(productId: String, quantity: Int)
    suspend fun clearCart()
}

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Boolean>
    suspend fun register(name: String, email: String, password: String): Result<Boolean>
    suspend fun logout()
    fun isUserLoggedIn(): Flow<Boolean>
}
