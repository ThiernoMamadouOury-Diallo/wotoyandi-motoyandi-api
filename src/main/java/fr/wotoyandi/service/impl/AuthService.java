package fr.wotoyandi.service.impl;

import fr.wotoyandi.model.User;

import java.util.List;

public interface AuthService {
    List<User> getAllUsers(String name);
}