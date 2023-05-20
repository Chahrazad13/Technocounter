package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.Cart;
import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.product.Product;
import com.groupe4.frontoffice.repository.cart.CartLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartLineService {
    @Autowired
    CartLineRepository cartLineRepository;

    public List<CartLine> fetchAll(){

        return cartLineRepository.findAll();
    }
    public List<CartLine> fetchAllByIdCart(int cartId) {
        return cartLineRepository.findAllByCartId(cartId);}

    public CartLine addItemToCart(Product product, int quantity, Cart cart){return cartLineRepository.save(new CartLine(cart, product, quantity));};

}