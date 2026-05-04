package com.example.shop.di

import android.content.Context
import androidx.room.Room
import com.example.shop.data.local.AppDatabase
import com.example.shop.data.local.CartDao
import com.example.shop.data.remote.ShopApiService
import com.example.shop.data.repository.CartRepositoryImpl
import com.example.shop.data.repository.ProductRepositoryImpl
import com.example.shop.domain.repository.CartRepository
import com.example.shop.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideShopApiService(): ShopApiService {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/") // Real public mock API
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ShopApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "shop_db"
        ).build()
    }

    @Provides
    fun provideCartDao(db: AppDatabase): CartDao = db.cartDao

    @Provides
    @Singleton
    fun provideProductRepository(api: ShopApiService): ProductRepository {
        return ProductRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideCartRepository(dao: CartDao): CartRepository {
        return CartRepositoryImpl(dao)
    }
}
