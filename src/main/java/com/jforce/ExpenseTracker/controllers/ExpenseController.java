package com.jforce.ExpenseTracker.controllers;

import com.jforce.ExpenseTracker.data.models.ExpenseModel;
import com.jforce.ExpenseTracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<?> getUserExpenses() {
        try {
            return new ResponseEntity<>(expenseService.getUserExpenses(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("new")
    public ResponseEntity<?> createExpense(@RequestBody ExpenseModel expenseModel) {
        try {
            expenseService.createExpense(expenseModel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
