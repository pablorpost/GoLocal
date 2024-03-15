package es.hack4good.golocal.repositories;

import java.util.HashMap;
import java.util.List;

import es.hack4good.golocal.entities.Store;

public class StoreRepository {
    private HashMap<Long, Store> stores;

    public StoreRepository() {
        stores = new HashMap<>();
    }

    public void addStore(Store store) {
        stores.put(store.getId(), store);
    }

    public Store findById(long id) {
        return stores.get(id);
    }

    public List<Store> findAll() {
        return (List<Store>) stores.values();
    }


}
