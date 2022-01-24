package com.example.controller

import com.example.model.Product
import com.example.repository.ProductRepository
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import jakarta.inject.Inject

@Controller("/products")
class ProductController(
    @Inject val productRepository: ProductRepository
) {
    
    @Get
    suspend fun products(): List<Product> {
        return productRepository.list()
    }
    
    @Post
    suspend fun saveProduct(product: Product) {
        productRepository.save(product)
    }
}