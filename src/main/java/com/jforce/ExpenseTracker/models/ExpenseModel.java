package com.jforce.ExpenseTracker.models;

import lombok.Data;

import java.util.Date;


@Data
public class ExpenseModel {

    String id;

    String name;

    float amount;

    Date date;

    String Description;
}
