package ru.def.learn.pp_3_1_2.dao;

import ru.def.learn.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void add(User user);
    void delete (int id);
    User getById(int id);
    void update(User user);
}
