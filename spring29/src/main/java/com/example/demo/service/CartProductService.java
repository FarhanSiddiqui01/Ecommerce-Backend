package com.example.demo.service;

import com.example.demo.domain.CartProduct;
import com.example.demo.domain.User;
import com.example.demo.exception.RecordNotFound;
import com.example.demo.repository.CartProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartProductService {
    private final CartProductRepository cartProductRepository;

    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }



    public CartProduct save(CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    public List<CartProduct> getAll() {
        return cartProductRepository.findAll();
    }

    public void deleteCartProduct(Long id) {
        if (presetById(id)){
        cartProductRepository.deleteById(id);}
        else{
            throw new RecordNotFound(String.format("No CartProduct found on id => %d",id));
        }
    }

    public boolean presetById(Long id) {
        Optional<CartProduct> cartProduct =  cartProductRepository.findById(id);
        if(cartProduct.isPresent()){
            return true;
        }
        else {return false;}

    }

    public Optional<CartProduct> getCartProductById(Long id) {
        return cartProductRepository.findById(id);
    }


    public ResponseEntity<CartProduct> update(CartProduct cartProduct, Long id) {
        if (presetById(id)){
            CartProduct updateCartProduct = getCartProductById(id).orElse(null);
            updateCartProduct.setProduct(cartProduct.getProduct());
            updateCartProduct.setAmount(cartProduct.getAmount());
            updateCartProduct.setQuantity(cartProduct.getQuantity());
            return ResponseEntity.ok(save(updateCartProduct));
        }else{
            throw new RecordNotFound(String.format("No CartProduct found on id => %d",id));
        }
    }

    }
