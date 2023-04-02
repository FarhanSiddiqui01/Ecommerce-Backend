package com.example.demo.controller;

import com.example.demo.domain.Cart;
import com.example.demo.domain.Category;
import com.example.demo.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping("/save")
    public ResponseEntity<Cart> save(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.save(cart));}

    @GetMapping("/get")
    public List<Cart> getAllCart(){
        return cartService.getAll();}

    @DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCart(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id,@RequestBody Cart cart) {
             return ResponseEntity.ok(cartService.update(cart,id));


    }}
