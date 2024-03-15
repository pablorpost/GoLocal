package es.hack4good.golocal.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.hack4good.golocal.database.entity.User;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    public List<User> getAllUsers();

    @Query("SELECT * FROM user WHERE id = :id")
    public User getUserById(long id);
    @Insert
    public void insertUser(User user);
    @Update
    public void updateUser(User user);
    @Delete
    public void deleteUser(User user);
}
