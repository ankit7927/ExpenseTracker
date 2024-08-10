package com.jforce.ExpenseTracker.data.repositories;

import com.jforce.ExpenseTracker.data.models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ExpenseRepository extends JpaRepository<ExpenseModel, Integer> {

    @Query(value = "select * from expense_model where username=:username", nativeQuery = true)
    List<ExpenseModel> getAllUserExpense(@Param("username") String username);
}
