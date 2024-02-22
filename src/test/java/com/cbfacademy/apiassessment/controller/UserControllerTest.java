package com.cbfacademy.apiassessment.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cbfacademy.apiassessment.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Test class for the UserController. Utilizes MockMvc to simulate HTTP requests
 * and verify the responses from the UserController.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the GET request for fetching a user by ID.
     * 
     * @throws Exception if the request fails
     */
    @Test
    public void testGetUserById() throws Exception {
        // Adjust the expected content string to match the actual output of your UserController
        mockMvc.perform(get("/users/12345")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("User ID is: 12345"));
    }

    /**
     * Test the POST request for creating a new user.
     * 
     * @throws Exception if the request fails
     */
    @Test
    public void testPostUser() throws Exception {
        // Define the user JSON
        String userJson = "{\"name\":\"John\", \"email\":\"john@example.com\"}";

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isCreated())
                .andExpect(content().string("User created successfully"));
    }

    /**
     * Test the PUT request for updating an existing user.
     * 
     * @throws Exception if the request fails
     */
    @Test
    public void testUpdateUser() throws Exception {
        // Define the updated user JSON
        String updatedUserJson = "{\"name\":\"John Updated\", \"email\":\"john.updated@example.com\"}";

        mockMvc.perform(put("/users/12345")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatedUserJson))
                .andExpect(status().isOk())
                .andExpect(content().string("User updated successfully"));
    }

    /**
     * Test the DELETE request for removing a user.
     * 
     * @throws Exception if the request fails
     */
    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/users/12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("User deleted successfully"));
    }

    // Add more test methods if needed to cover more scenarios or different aspects of the UserController
}
