package com.smart.expense_tracker_api.service;

import java.util.List;

import com.smart.expense_tracker_api.model.Expense;

/**
 *
 * @author Pedro
 */
public interface ExpenseService {

    /**
     * Saves the Expense entity
     * @param expense the Expense tu save
     * @return the saved Expense
     */
    Expense saveExpense(Expense expense);

    /**
     * Fetch the list of all Expenses entities
     * @return a list of Expenses
     */
    List<Expense> getExpensesList();

    /**
     * Updates an existing Expense
     * @param expense the Expense with updated information
     * @param expenseId the ID of the Expense to update
     * @return the udpated Expense
     */
    Expense updateExpense(Expense expense, Long expenseId);

    /**
     * Deletes a department entity by its ID.
     * @param expenseId the ID of the department to delete
     */
    void deleteExpenseById(Long expenseId);

}
