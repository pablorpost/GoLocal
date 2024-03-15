package es.hack4good.golocal.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.ProductType;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM product")
    public List<Product> getAllProducts();
    @Query("SELECT * FROM product WHERE id = :id")
    public Product getProductById(long id);
    @Query("SELECT * FROM product WHERE store_id = :storeId")
    public List<Product> getProductsByStoreId(long storeId);
    @Query("SELECT * FROM product WHERE store_id = :storeId AND type = :type")
    public List<Product> getProductsByStoreIdAndType(long storeId, ProductType type);
    @Insert
    public void insertProduct(Product product);
    @Update
    public void updateProduct(Product product);
    @Delete
    public void deleteProduct(Product product);
}
