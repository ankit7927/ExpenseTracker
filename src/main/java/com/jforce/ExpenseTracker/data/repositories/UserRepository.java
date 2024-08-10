package com.jforce.ExpenseTracker.data.repositories;

import com.jforce.ExpenseTracker.data.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query(value = "select * from user_model where username=:username", nativeQuery = true)
    UserModel getUserWithUsername(@Param("username") String username);
}
