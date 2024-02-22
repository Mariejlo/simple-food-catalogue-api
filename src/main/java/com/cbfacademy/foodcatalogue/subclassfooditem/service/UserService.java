package com.cbfacademy.foodcatalogue.subclassfooditem.service;

import com.cbfacademy.apiassessment.model.User;
import org.springframework.stereotype.Service;

@Service 
public class UserService {

    public User getUserById(Long userId) {
        User user = new User();
        user.setId(userId);
        user.setFirstName("John");
        user.setLastName("Doe");
        return user;

        // TODO: Implement this method to return user by userID
        // Example: return ResponseEntity.ok(userService.getUserById(userId));
        
    }
}
