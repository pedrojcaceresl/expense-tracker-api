/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.smart.expense_tracker_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.expense_tracker_api.model.Expense;
import com.smart.expense_tracker_api.service.ExpenseServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 *
 * @author Pedro
 */
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseServiceImpl expenseService;


    @GetMapping()
    public ResponseEntity<List<Expense>> getExpenses() {
        return ResponseEntity.ok(this.expenseService.getExpensesList());
    }

    @PostMapping()
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense savedExpense = expenseService.saveExpense(expense);

        // Verifica si el objeto se guardó correctamente
        if (savedExpense.getExpenseId() == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(savedExpense);
    }
    
    
}
