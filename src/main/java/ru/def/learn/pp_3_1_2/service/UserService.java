package ru.def.learn.pp_3_1_2.service;


import ru.def.learn.pp_3_1_2.model.User;

import java.util.List;

public interface UserService {
    List<User> index ();
    void add(User user);
    void delete (int id);
    User id(int id);
    void update(User user);


}