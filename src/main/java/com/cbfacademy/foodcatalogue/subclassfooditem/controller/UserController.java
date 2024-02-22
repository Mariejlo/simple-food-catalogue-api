package com.cbfacademy.foodcatalogue.subclassfooditem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

 //Class definition section
@RestController // Indicates that this class is a controller
@RequestMapping("/api/users") // Base path for all requests handled by this controller
public class UserController {
    // Class body

   @Autowired // This sets the base path for all requests handled by this controller
   private UserService userService;  // Assuming you have a UserService

   // Get all users
   @GetMapping("/") // Endpoint for getting all users
   public ResponseEntity<List<User>> getAllUsers() {
        // Implement this method to return a list of all the users
        // Example: return ResponseEntity.ok(userService.getAllUsers());
        return ResponseEntity.ok().build(); // Temporary response
}

    // Get user by ID
    @GetMapping("/{userId}") // Endpoint for getting a user by ID
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        // Implement this method to return user by userID
        // Example: return ResponseEntity.ok(userService.getUserById(userId));
        return ResponseEntity.ok().build(); // Temporary response
    }

    // Additional methods for other operations (create, update, delete) can be added here.  
} //End of UserController class




