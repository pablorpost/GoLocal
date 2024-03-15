package es.hack4good.golocal.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import es.hack4good.golocal.entities.Product;
import es.hack4good.golocal.entities.ProductType;

public class ProductRepository {
    private HashMap<Long, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public List<Product> findByStoreId(long storeId) {
        List<Product> storeProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getStoreId() == storeId) {
                storeProducts.add(product);
            }
        }
        return storeProducts;
    }

    public List<Product> findByProductTypeStoreId(long storeId, ProductType productType) {
        List<Product> storeProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getStoreId() == storeId && product.getType() == productType) {
                storeProducts.add(product);
            }
        }
        return storeProducts;
    }

    public List<Product> findByProductType(ProductType productType) {
        List<Product> storeProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getType() == productType) {
                storeProducts.add(product);
            }
        }
        return storeProducts;
    }

    public Product findById(long id) {
        return products.get(id);
    }

    public void save(Product product) {
        products.put(product.getId(), product);
    }





}
