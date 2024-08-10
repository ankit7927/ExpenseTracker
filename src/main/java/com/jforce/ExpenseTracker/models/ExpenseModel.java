package com.jforce.ExpenseTracker.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document("expense")
@Data
public class ExpenseModel {
    @MongoId
    String id;

    String name;

    float amount;

    Date date;

    String Description;
}
