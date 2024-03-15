package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.dao.UserDAO;
import es.hack4good.golocal.database.entity.User;

public class UserRepositoryImpl implements UserRepository {

    private UserDAO userDao;

    public UserRepositoryImpl (UserDAO userDao){
        this.userDao = userDao;
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
