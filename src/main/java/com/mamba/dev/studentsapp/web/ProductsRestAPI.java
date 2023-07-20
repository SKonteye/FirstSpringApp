package com.mamba.dev.studentsapp.web;

import com.mamba.dev.studentsapp.entities.Product;
import com.mamba.dev.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsRestAPI {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> products (){
        return productRepository.findAll();
    };
    @GetMapping("/products/{id}")
    public Product findproduct (@PathVariable Long id){
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
}
