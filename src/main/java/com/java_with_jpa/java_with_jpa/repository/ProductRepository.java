package com.java_with_jpa.java_with_jpa.repository;

import com.java_with_jpa.java_with_jpa.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
