package com.smart.expense_tracker_api.service;

import com.smart.expense_tracker_api.model.User;
import com.smart.expense_tracker_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDB = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        for (Field field : User.class.getDeclaredFields()) {
            field.setAccessible(true);

            try {
                Object newValue = field.get(user);
                if (newValue != null && !newValue.toString().trim().isEmpty()) {
                    field.set(userDB, newValue);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error actualizando los campos de Usuario");
            }
        }

        return userRepository.save(userDB);
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }


}
