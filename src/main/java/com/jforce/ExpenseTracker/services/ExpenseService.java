package com.jforce.ExpenseTracker.services;


import com.jforce.ExpenseTracker.data.models.ExpenseModel;
import com.jforce.ExpenseTracker.data.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public void createExpense(@RequestBody ExpenseModel expenseModel) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        expenseModel.setUsername(principal.getUsername());
        expenseRepository.save(expenseModel);
    }

    public List<ExpenseModel> getUserExpenses() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return expenseRepository.getAllUserExpense(principal.getUsername());
    }
}
