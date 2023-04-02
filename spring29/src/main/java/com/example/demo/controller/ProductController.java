package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping("/get")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();

    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product product) {

            return ResponseEntity.ok(productService.update(product,id));
        }

    }





