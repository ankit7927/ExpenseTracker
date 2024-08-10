package com.jforce.ExpenseTracker.services;

import com.jforce.ExpenseTracker.data.models.UserModel;
import com.jforce.ExpenseTracker.data.repositories.UserRepository;
import com.jforce.ExpenseTracker.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userWithUsername = userRepository.getUserWithUsername(username);
        if (userWithUsername == null) throw new UsernameNotFoundException("Unknown user");
        return User.withUserDetails(new UserDetailsImpl(userWithUsername)).build();
    }
}
