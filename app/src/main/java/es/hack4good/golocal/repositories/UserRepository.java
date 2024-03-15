package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.entity.User;

public interface UserRepository {
    List<User> getAllUsers();
    User getUserById(long id);
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);


}
