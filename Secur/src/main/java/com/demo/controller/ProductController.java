package com.demo.controller;

import com.demo.domain.Product;
import com.demo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product newProduct=productService.save(product);
        return ResponseEntity.ok(newProduct);
    }
    @PostMapping("/products")
      public ResponseEntity<Product> update(@RequestBody Product product){
      Product newProduct=productService.save(product);
      return ResponseEntity.ok(newProduct);
 }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id){
        Product product=productService.findOne(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/product/")
    public ResponseEntity<?> getAll(Pageable pageable){
       Page<Product> product=productService.findAll(pageable);
       return ResponseEntity.ok(product);
    }
    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}
