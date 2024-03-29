package es.hack4good.golocal.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.hack4good.golocal.database.entity.Store;
@Dao
public interface StoreDAO {
    @Query("SELECT * FROM store")
    public List<Store> getAllStores();

    @Query("SELECT * FROM store WHERE id = :id")
    public Store getStoreById(long id);

    @Query("SELECT * FROM store WHERE name = :name")
    public Store getStoreByName(String name);
    @Insert
    public void insert(Store store);
    @Update
    public void updateStore(Store store);
    @Delete
    public void deleteStore(Store store);

}
