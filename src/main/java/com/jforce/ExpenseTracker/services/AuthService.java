package com.jforce.ExpenseTracker.services;

import com.jforce.ExpenseTracker.data.models.UserModel;
import com.jforce.ExpenseTracker.data.repositories.UserRepository;
import com.jforce.ExpenseTracker.utils.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtility jwtUtility;

    public void userLogin(UserModel userModel) throws Exception {
        UserModel userWithUsername = userRepository.getUserWithUsername(userModel.getUsername());
        if (userWithUsername.getPassword().equals(userModel.getPassword())) {

        } else throw new Exception("Wrong username or password");
    }


    public UserModel userRegistration(UserModel userModel) {
        UserModel savedUser = userRepository.save(userModel);
        savedUser.setPassword("");
        return savedUser;
    }
}
