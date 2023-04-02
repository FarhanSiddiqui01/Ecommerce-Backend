package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.exception.RecordNotFound;
import com.example.demo.repository.ProductReposiroty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductReposiroty productReposiroty;

    public ProductService(ProductReposiroty productReposiroty) {
        this.productReposiroty = productReposiroty;
    }

    public Product save(Product product) {
        return productReposiroty.save(product);
    }

    public List<Product> getAllProduct() {
        return productReposiroty.findAll();
    }

    public void deleteById(Long id) {
        if (presetById(id)) {
        productReposiroty.deleteById(id);}else {
            throw new RecordNotFound(String.format("No Product found on id => %d",id));

        }
    }

    public boolean presetById(Long id) {
        Optional<Product> product =  productReposiroty.findById(id);
        if(product.isPresent()){
            return true;
        }
        else {return false;}
    }

    public Optional<Product> getProductById(Long id) {
        return productReposiroty.findById(id);
    }

    public ResponseEntity update(Product product, Long id) {
        if (presetById(id)) {
            Product updateProduct = getProductById(id).orElse(null);
            updateProduct.setName(product.getName());
            updateProduct.setImage(product.getImage());
            updateProduct.setPrice(product.getPrice());
            updateProduct.setDescription(product.getDescription());
            updateProduct.setCategory(product.getCategory());
            return ResponseEntity.ok(save(updateProduct));
    }else {
            throw new RecordNotFound(String.format("No Product found on id => %d",id));
        }
    }
}
