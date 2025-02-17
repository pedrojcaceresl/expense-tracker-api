package com.smart.expense_tracker_api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.expense_tracker_api.model.Expense;
import com.smart.expense_tracker_api.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;

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
         return expenseRepository.findById(expenseId)
            .map(existingExpense -> {
                BeanUtils.copyProperties(expense, existingExpense, "id");
                return expenseRepository.save(existingExpense);
            })
            .orElseThrow(() -> new EntityNotFoundException("Expense con ID " + expenseId + " no ha sido encontrado"));
    }

    @Override
    public void deleteExpenseById(Long expenseId) {
        if (!expenseRepository.existsById(expenseId)) {
            throw new EntityNotFoundException("Expense con ID " + expenseId + "no encontrado.");
        }
        expenseRepository.deleteById(expenseId);
    }

}
