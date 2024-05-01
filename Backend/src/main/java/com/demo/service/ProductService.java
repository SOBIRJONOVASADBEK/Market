package com.demo.service;

import com.demo.domain.Product;
import com.demo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public Product findOne(Long id){
        Optional<Product>optional=productRepository.findById(id);
        if (optional.isPresent()){
            Product product=optional.get();
        }
        return null;
    }
    public Page<Product> findAll(Pageable pageable){
        Page<Product> page=productRepository.findAll(pageable);
        return page;
    }
    public void  delete(Long id){
        productRepository.deleteById(id);
    }
}
