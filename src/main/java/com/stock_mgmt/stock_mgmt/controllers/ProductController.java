package com.stock_mgmt.stock_mgmt.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stock_mgmt.stock_mgmt.entity.Product;
import com.stock_mgmt.stock_mgmt.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    List<Product> create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping
    List<Product> list(){
        return productService.list();
    }

    @PutMapping("{id}")
    List<Product> update(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("{id}")
    List<Product> delete(@PathVariable Long id){
        return productService.delete(id);
    }
    
}