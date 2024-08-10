package com.jforce.ExpenseTracker.models;

import lombok.Data;


@Data
public class UserModel {
    int id;

    String name;

    String email;

    String username;

    String password;
}
