package es.hack4good.golocal.repositories;
import es.hack4good.golocal.database.dao.StoreDAO;
import es.hack4good.golocal.database.entity.Store;
import java.util.List;
public class StoreRepositoryImpl implements StoreRepository{
    private StoreDAO storeDAO;

    public StoreRepositoryImpl(StoreDAO storeDAO){
        this.storeDAO = storeDAO;
    }

    @Override
    public List<Store> getAllStores(){
        return storeDAO.getAllStores();
    }

    @Override
    public Store getStoreById(long id){
        return storeDAO.getStoreById(id);
    }

    @Override
    public Store getStoreByName(String name){
        return storeDAO.getStoreByName(name);
    }

    @Override
    public void insertStore(Store store){
        storeDAO.insertStore(store);
    }

    @Override
    public void updateStore(Store store){
        storeDAO.updateStore(store);
    }

    @Override
    public void deleteStore(Store store){
        storeDAO.deleteStore(store);
    }


}
