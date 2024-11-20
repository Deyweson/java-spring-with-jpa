package com.java_with_jpa.java_with_jpa.controller;

import com.java_with_jpa.java_with_jpa.Models.Product;
import com.java_with_jpa.java_with_jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;


    @GetMapping
    public List<Product> GetProducts(){
        return productRepository.findAll();
    }

}
