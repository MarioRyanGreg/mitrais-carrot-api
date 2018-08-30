package com.mitrais.carrot.services;

import org.springframework.stereotype.Service;

import com.mitrais.carrot.models.User;

@Service
public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user, String role);
}
