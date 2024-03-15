package es.hack4good.golocal.database.dao;

import androidx.room.Query;

import es.hack4good.golocal.models.ProductType;

public class ProductDAO {
    @Query("SELECT * FROM product")
    public void getAllProducts() {
    }
    @Query("SELECT * FROM product WHERE id = :id")
    public void getProductById(long id) {
    }
    @Query("SELECT * FROM product WHERE store_id = :storeId")
    public void getProductsByStoreId(long storeId) {
    }
    @Query("SELECT * FROM product WHERE store_id = :storeId AND type = :type")
    public void getProductsByStoreIdAndType(long storeId, ProductType type) {
    }
}
