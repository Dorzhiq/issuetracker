package com.axmor.controllers;

import com.axmor.user.User;
import org.mindrot.jbcrypt.BCrypt;

import static com.axmor.Main.userDao;

public class UserController {
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, user.getSalt());
        return hashedPassword.equals(user.getHashedPassword());
    }

}
