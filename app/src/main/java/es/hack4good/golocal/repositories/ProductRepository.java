package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.ProductType;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProductById(long id);
    List<Product> getProductsByStoreId(long storeId);
    List<Product> getProductsByStoreIdAndType(long storeId, ProductType type);
    void insertProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);


}
