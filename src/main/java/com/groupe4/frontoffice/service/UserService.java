package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User fetchById(int id) { return userRepository.findById(id);}

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email) { return userRepository.findByEmail(email).get();}

    public void addCartLine(User user, CartLine cartLine) {
        List<CartLine> cartLines = user.getCart().getCartlines();
        cartLines.add(cartLine);
        cartLine.setCart(user.getCart());
        user.getCart().setCartlines(cartLines);
        userRepository.save(user);
    }
}