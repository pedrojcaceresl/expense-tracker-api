

package com.smart.expense_tracker_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long expenseId;

    private String name;
    private String category;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private String paymentMethod;

    @ManyToOne(cascade =  CascadeType.ALL) // Ensures dependent expenses are deleted
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
