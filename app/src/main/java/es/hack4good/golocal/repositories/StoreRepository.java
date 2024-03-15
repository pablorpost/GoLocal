package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.entity.Store;

public interface StoreRepository {

    List<Store> getAllStores();
    Store getStoreById(long id);
    Store getStoreByName(String name);
    void insertStore(Store store);
    void updateStore(Store store);
    void deleteStore(Store store);
}
