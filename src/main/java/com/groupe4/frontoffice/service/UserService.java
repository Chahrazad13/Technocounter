package com.groupe4.frontoffice.service;

import com.groupe4.frontoffice.model.cart.CartLine;
import com.groupe4.frontoffice.dto.UserDto;
import com.groupe4.frontoffice.model.user.User;
import com.groupe4.frontoffice.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User fetchById(int id) { return userRepository.findById(id);}

    public List<User> fetchAll(){
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    public void addCartLine(User user, CartLine cartLine) {
        List<CartLine> cartLines = user.getCart().getCartlines();
        cartLines.add(cartLine);
        cartLine.setCart(user.getCart());
        user.getCart().setCartlines(cartLines);
        userRepository.save(user);
    }

    public void save(User user){userRepository.save(user);}
}