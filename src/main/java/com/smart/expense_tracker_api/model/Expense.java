

package com.smart.expense_tracker_api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Pedro
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Expense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long expenseId;

    private String name;
    private String category;
    private double amount;
    private LocalDate date;
    private String description;
    private String paymentMethod;
}
