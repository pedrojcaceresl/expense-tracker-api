package com.smart.expense_tracker_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.expense_tracker_api.model.Expense;

/**
 *
 * @author Pedro
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public Expense saveExpense(Expense expense) {
        throw new UnsupportedOperationException("Unimplemented method 'saveExpense'");
    }

    @Override
    public List<Expense> getExpensesList() {
        Expense expense = new Expense();
        expense.setName("Cinema Hobby");
        expense.setDescription("Good times");

        List<Expense> expenses = new ArrayList<Expense>();
        expenses.add(expense);

        return expenses;
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
