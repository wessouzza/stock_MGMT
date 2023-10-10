package com.stock_mgmt.stock_mgmt.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.stock_mgmt.stock_mgmt.entity.Product;
import com.stock_mgmt.stock_mgmt.exception.ErrorMessge;
import com.stock_mgmt.stock_mgmt.repository.ProductRepository;
import java.util.List;


@Service
public class ProductService {
    
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> create(Product product){
        productRepository.save(product);
        return list();
    }

    public List<Product> list(){
        Sort sort = Sort.by("id").descending();
        return productRepository.findAll(sort);
    }

    public List<Product> update(Long id, Product product){
        productRepository.findById(id).ifPresentOrElse((existingProduct) -> {
            product.setId(id);
            productRepository.save(product);
        }, ()-> {
            throw new ErrorMessge("Product not found.");
        });
        
        return list();
    }

    public List<Product> delete(Long id){
        productRepository.deleteById(id);
        return list();
    }

}