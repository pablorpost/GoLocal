package es.hack4good.golocal.models;


import android.util.Pair;

import java.util.ArrayList;
import java.util.List;


import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Order;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.database.entity.User;

public class Basket {
    private static List<Pair<Product, Integer>> products;
    private static User user;

    public Basket(User user) {
        if (products == null) {
            products = new ArrayList<>();
        }
        this.user = user;
    }

    public boolean addProduct(Product product, int quantity) {
        for (int i = 0; i < products.size(); i++) {
            Pair<Product, Integer> p = products.get(i);
            if (p.first .getId() == product.getId()) {
                products.set(i, new Pair<>(p.first, p.second + quantity));
                return true;
            }
        }
        products.add(new Pair<>(product, quantity));
        return true;
    }

    public boolean removeProduct(Product product, int quantity) {
        for (int i = 0; i < products.size(); i++) {
            Pair<Product, Integer> p = products.get(i);
            if (p.first.getId() == product.getId()) {
                if (p.second - quantity <= 0) {
                    products.remove(i);
                } else {
                    products.set(i, new Pair<>(p.first, p.second - quantity));
                }
                return true;
            }
        }
        return false;
    }

    public static List<Pair<Product, Integer>> getProducts() {
        return products;
    }

    public boolean makeOrder(){
        AppDatabase db = AppDatabase.buildDatabaseInstance(null,"golocal",false);
        for (Pair<Product, Integer> p : products) {
            Order o = new Order(user.getId(), p.first.getId(), p.first.getPrice()*p.second, p.second, "date", "location", false, OrderStatus.PENDING);
            db.orderDAO().insertOrder(o);
            return true;
        }
        return false;
    }
}
