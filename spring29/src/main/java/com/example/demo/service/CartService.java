package com.example.demo.service;

import com.example.demo.domain.Cart;
import com.example.demo.domain.User;
import com.example.demo.exception.RecordNotFound;
import com.example.demo.repository.CartRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public void deleteCart(Long id) {
        if (presetById(id)){
        cartRepository.deleteById(id);}else {
            throw new RecordNotFound(String.format("No Cart found on id => %d",id));
        }
    }

    public boolean presetById(Long id) {
        Optional<Cart> cart =  cartRepository.findById(id);
        if(cart.isPresent()){
            return true;
        }
        else {return false;}

    }

    public Optional<Cart> getCartById(Long id) {
    return cartRepository.findById(id);
    }


    public ResponseEntity<Cart> update(Cart cart, Long id) {
        if (presetById(id)) {
            Cart updateCart = getCartById(id).orElse(null);
            updateCart.setCreatedAt(cart.getCreatedAt());
            updateCart.setCartProducts(cart.getCartProducts());

            return ResponseEntity.ok(save(updateCart));

        }else{
        throw new RecordNotFound(String.format("No Cart found on id => %d",id));
        }
    }

    }
