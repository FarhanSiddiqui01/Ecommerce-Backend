package com.example.demo.controller;

import com.example.demo.domain.CartProduct;
import com.example.demo.domain.Category;
import com.example.demo.service.CartProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

public class CartProductController {
    private final CartProductService cartProductService;

    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }
    @PostMapping("/save")
    public ResponseEntity<CartProduct> save(@RequestBody CartProduct cartProduct){
        return ResponseEntity.ok(cartProductService.save(cartProduct));}

    @GetMapping("/get")
    public List<CartProduct> getAllCartProduct(){
        return cartProductService.getAll();}

    @DeleteMapping("/delete/{id}")
    public void deleteCartProduct(@PathVariable Long id){
        cartProductService.deleteCartProduct(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCartProduct(@PathVariable Long id,@RequestBody CartProduct cartProduct){

            return ResponseEntity.ok(cartProductService.update(cartProduct,id));


    }}
