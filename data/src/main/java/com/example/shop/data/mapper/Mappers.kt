package com.example.shop.data.mapper

import com.example.shop.data.local.CartEntity
import com.example.shop.data.remote.ProductDto
import com.example.shop.domain.model.CartItem
import com.example.shop.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id.toString(),
        title = title,
        price = price,
        description = description,
        category = category,
        image = image,
        rating = rating?.rate ?: 0.0
    )
}

fun CartEntity.toDomain(): CartItem {
    return CartItem(
        productId = productId,
        title = title,
        price = price,
        imageUrl = imageUrl,
        quantity = quantity
    )
}

fun CartItem.toEntity(): CartEntity {
    return CartEntity(
        productId = productId,
        title = title,
        price = price,
        imageUrl = imageUrl,
        quantity = quantity
    )
}
