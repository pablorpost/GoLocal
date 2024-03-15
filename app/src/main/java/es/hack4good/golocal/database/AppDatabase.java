package es.hack4good.golocal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import es.hack4good.golocal.database.dao.OrderDAO;
import es.hack4good.golocal.database.dao.ProductDAO;
import es.hack4good.golocal.database.dao.StoreDAO;
import es.hack4good.golocal.database.dao.UserDAO;
import es.hack4good.golocal.database.entity.Order;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.database.entity.Store;
import es.hack4good.golocal.database.entity.User;

@Database(entities = {
        Order.class,
        Product.class,
        Store.class,
        User.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public static AppDatabase INSTANCE;

    public abstract OrderDAO orderDAO();
    public abstract ProductDAO productDAO();
    public abstract StoreDAO storeDAO();
    public abstract UserDAO userDAO();
    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "golocal")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
