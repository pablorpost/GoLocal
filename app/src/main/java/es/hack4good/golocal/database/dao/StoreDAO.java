package es.hack4good.golocal.database.dao;

import androidx.room.Query;

import java.util.List;

import es.hack4good.golocal.database.entity.Store;

public interface StoreDAO {
    @Query("SELECT * FROM store")
    public List<Store> getAllStores();

    @Query("SELECT * FROM store WHERE id = :id")
    public Store getStoreById(long id);

    @Query("SELECT * FROM store WHERE name = :name")
    public Store getStoreByName(String name);
}
