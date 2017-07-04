package com.mastercard.service;

import com.mastercard.model.Tweet;
import com.mastercard.model.User;

import java.util.HashMap;

/**
 * Created by e068806 on 7/3/2017.
 */
public class UserService {
    private HashMap<Long, User> users = new HashMap<>();
    private static UserService userService;
    private Long id = 0l;

    public static UserService getInstance() {
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    public User createUser(User t) {
        if (t.getUserName() == null || "".equals(t.getUserName()))
            return null;
        t.setId(id.longValue());
        users.put(t.getId(), t);
        id++;
        return t;
    }

    public User updateUser(User t) {
        if (t.getId() == null || t.getUserName() == null)
            return null;

        users.put(t.getId(), t);
        return t;
    }

    public void removeUser(Tweet t) {
        if (t.getId() == null)
            return;

        users.remove(t.getId());
    }

    public User getUser(Long id) {
        return users.get(id);
    }

}
