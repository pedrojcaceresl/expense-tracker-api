package com.smart.expense_tracker_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.expense_tracker_api.model.Expense;

/**
 *
 * @author Pedro
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {}
