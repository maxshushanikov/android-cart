package com.example.shop.data.repository

import com.example.shop.data.local.CartDao
import com.example.shop.data.mapper.toDomain
import com.example.shop.data.mapper.toEntity
import com.example.shop.data.remote.ShopApiService
import com.example.shop.domain.model.CartItem
import com.example.shop.domain.model.Product
import com.example.shop.domain.repository.CartRepository
import com.example.shop.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ShopApiService
) : ProductRepository {
    override suspend fun getProducts(): Result<List<Product>> {
        return try {
            val response = api.getProducts()
            Result.success(response.map { it.toDomain() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getProductById(id: String): Result<Product> {
        return try {
            val response = api.getProduct(id.toInt())
            Result.success(response.toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCategories(): Result<List<String>> {
        return try {
            val response = api.getCategories()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}

class CartRepositoryImpl @Inject constructor(
    private val dao: CartDao
) : CartRepository {
    override fun getCartItems(): Flow<List<CartItem>> {
        return dao.getCartItems().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addToCart(item: CartItem) {
        dao.insertCartItem(item.toEntity())
    }

    override suspend fun removeFromCart(productId: String) {
        dao.deleteCartItem(productId)
    }

    override suspend fun updateQuantity(productId: String, quantity: Int) {
        dao.updateQuantity(productId, quantity)
    }

    override suspend fun clearCart() {
        dao.clearCart()
    }
}
