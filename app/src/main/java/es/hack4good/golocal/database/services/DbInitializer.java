package es.hack4good.golocal.database.services;

import es.hack4good.golocal.database.AppDatabase;
import es.hack4good.golocal.database.entity.Order;

public class DbInitializer {

    public void initialize(AppDatabase db) {
        if(db.productDAO().getAllProducts().isEmpty()) {
            // Insert stores

            // Insert products

            // Insert users

            // Insert orders

        }
    }
}
