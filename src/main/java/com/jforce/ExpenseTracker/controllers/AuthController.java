package com.jforce.ExpenseTracker.controllers;

import com.jforce.ExpenseTracker.data.models.UserModel;
import com.jforce.ExpenseTracker.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> userLogin(@RequestBody UserModel userModel) {
        if (userModel.getUsername().isEmpty() || userModel.getPassword().isEmpty())
            return new ResponseEntity<>("Username password are required", HttpStatus.BAD_REQUEST);
        try {
            return new ResponseEntity<>(authService.userLogin(userModel), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("register")
    public ResponseEntity<?> userRegistration(@RequestBody UserModel userModel) {
        try {
            UserModel userModel1 = authService.userRegistration(userModel);

            return new ResponseEntity<>(userModel1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
