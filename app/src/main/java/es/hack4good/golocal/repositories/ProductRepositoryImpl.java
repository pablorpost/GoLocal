package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.dao.ProductDAO;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.models.ProductType;

public class ProductRepositoryImpl implements ProductRepository{

    private ProductDAO productDAO;

    public ProductRepositoryImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public List<Product> getProductsByStoreId(long storeId) {
        return productDAO.getProductsByStoreId(storeId);
    }

    @Override
    public List<Product> getProductsByStoreIdAndType(long storeId, ProductType type) {
        return productDAO.getProductsByStoreIdAndType(storeId, type);
    }

    @Override
    public void insertProduct(Product product) {
        productDAO.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productDAO.deleteProduct(product);
    }





}
