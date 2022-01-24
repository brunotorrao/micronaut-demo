package com.example.repository

import com.example.model.Product
import com.mongodb.reactivestreams.client.MongoClient
import jakarta.inject.Singleton
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst


@Singleton
class ProductRepository (
    mongoClient: MongoClient
) {
    suspend fun save(product: Product) {
        collection.insertOne(product).awaitFirst()
    }
    
    suspend fun list(): List<Product> {
        return collection.find().asFlow().toList()
    }
    
    private val collection = mongoClient.getDatabase("product")
            .getCollection("products", Product::class.java)
}