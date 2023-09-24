package ru.def.learn.pp_3_1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.def.learn.pp_3_1_2.dao.UserDao;
import ru.def.learn.pp_3_1_2.model.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserDao userDAO;

    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
