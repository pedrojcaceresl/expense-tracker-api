package com.smart.expense_tracker_api.dto;

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
public class RegisterUserDTO {
    private String email;

    private String password;

    private String fullname;
    
    private String username;
}
