package com.jforce.ExpenseTracker.data.repositories;

import com.jforce.ExpenseTracker.data.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface ExpenseRepository extends JpaRepository<ExpenseModel, Integer> {
}
