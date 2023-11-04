package com.stock_mgmt.stock_mgmt.controllers;

import java.util.List;

import com.stock_mgmt.stock_mgmt.exception.ErrorMessge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/products")
public class ProductController {

    final private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Product product){
        try{
            List<Product> product01 = productService.create(product);
            return ResponseEntity.ok(product01);
        }catch (ErrorMessge msg){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(msg.getMessage());
        }
    }

    @GetMapping
    List<Product> list(){
        return productService.list();
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<?> getOneByName(@PathVariable String name){
        try{
            List<Product> product = productService.getOneByName(name);
            return ResponseEntity.ok(product);
        }catch (ErrorMessge msg) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
        }
    }

    @GetMapping("/findSku/{sku}")
    public ResponseEntity<?> getOneBySku(@PathVariable Long sku){
        try {
            Product productSku = productService.getOneBySku(sku);
            return ResponseEntity.ok(productSku);
        }catch (ErrorMessge msg){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Product product){
        try {
            List<Product> product01 = productService.update(id, product);
            return ResponseEntity.ok(product01);
        }catch (ErrorMessge msg){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg.getMessage());
        }
    }

    @DeleteMapping("{id}")
    List<Product> delete(@PathVariable Long id){
        return productService.delete(id);
    }
    
}