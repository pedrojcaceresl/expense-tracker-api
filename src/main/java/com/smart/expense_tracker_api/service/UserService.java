package com.smart.expense_tracker_api.service;

import com.smart.expense_tracker_api.model.User;

import java.util.List;

/**
 * Interfaz de servicio para la entidad User
 * Define metodos de CRUD y lógica de negocio adicional
 */
public interface UserService {

    /**
     * Saves the user entity
     * @param user the user tu save
     * @return the saved user
     */
    User saveUser(User user);

    /**
     * Fetch the list of all users entities
     * @return a list of users
     */
    List<User> getUserList();

    /**
     * Updates an existing user
     * @param user the user with updated information
     * @param userId the ID of the user to update
     * @return the udpated user
     */
    User updateUser(User user, Long userId);

    /**
     * Deletes a department entity by its ID.
     * @param userId the ID of the department to delete
     */
    void deleteUserById(Long userId);
}
