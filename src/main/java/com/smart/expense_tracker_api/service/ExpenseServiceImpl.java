package com.smart.expense_tracker_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.expense_tracker_api.model.Expense;
import com.smart.expense_tracker_api.repository.ExpenseRepository;

/**
 *
 * @author Pedro
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense saveExpense(Expense expense) {
        if (expense.getUser() == null || expense.getUser().getId() == null) {
            throw new RuntimeException("El usuario no puede ser nulo y debe tener un ID válido");
        }

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getExpensesList() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense updateExpense(Expense expense, Long expenseId) {
        throw new UnsupportedOperationException("Unimplemented method 'updateExpense'");
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteExpenseById'");
    }

}
