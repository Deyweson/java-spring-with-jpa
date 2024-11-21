package com.java_with_jpa.java_with_jpa.controller;

import com.java_with_jpa.java_with_jpa.Models.Product;
import com.java_with_jpa.java_with_jpa.utils.ResponseHandle;
import com.java_with_jpa.java_with_jpa.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> GetProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetProduct(@PathVariable Integer id){

        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            return ResponseHandle.generate("Product Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Object>(product.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Product product){
        Product newProduct = productRepository.save(product);
        return new ResponseEntity<Object>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable @Valid Integer id, @RequestBody Product product){
        Optional<Product> oldProduct = productRepository.findById(id);

        if(oldProduct.isPresent()){
            return ResponseHandle.generate("Product Not Found", HttpStatus.NOT_FOUND);
        }

        Product updateProduct = oldProduct.get();
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        productRepository.save(updateProduct);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){

        Optional<Product> oldProduct = productRepository.findById(id);

        if(oldProduct.isPresent()){
            return ResponseHandle.generate("Product Not Found", HttpStatus.NOT_FOUND);
        }

        productRepository.delete(oldProduct.get());
        return ResponseEntity.noContent().build();
    }
}
