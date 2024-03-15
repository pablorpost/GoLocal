package es.hack4good.golocal.database.dao;

import androidx.room.Query;

import java.util.List;

import es.hack4good.golocal.database.entity.User;


public interface UserDAO {
    @Query("SELECT * FROM user")
    public List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    public User getUserById(long id);
}
