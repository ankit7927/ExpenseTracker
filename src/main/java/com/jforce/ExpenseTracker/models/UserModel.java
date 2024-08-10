package com.jforce.ExpenseTracker.models;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("Users")
@Data
public class UserModel {
    @MongoId
    String id;

    String name;

    @Indexed(unique = true, background = true)
    String email;

    @Indexed(unique = true, background = true)
    String username;

    String password;
}
