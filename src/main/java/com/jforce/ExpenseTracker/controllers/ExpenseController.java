package com.jforce.ExpenseTracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    @GetMapping
    public void test() {
        System.out.println("test secure route");
    }
}
