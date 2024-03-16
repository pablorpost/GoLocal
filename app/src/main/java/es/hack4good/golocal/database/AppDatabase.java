package es.hack4good.golocal.database;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.io.File;

import es.hack4good.golocal.database.dao.OrderDAO;
import es.hack4good.golocal.database.dao.ProductDAO;
import es.hack4good.golocal.database.dao.StoreDAO;
import es.hack4good.golocal.database.dao.UserDAO;
import es.hack4good.golocal.database.entity.Order;
import es.hack4good.golocal.database.entity.Product;
import es.hack4good.golocal.database.entity.Store;
import es.hack4good.golocal.database.entity.User;
import es.hack4good.golocal.database.services.DbInitializer;

@Database(entities = {
        Order.class,
        Product.class,
        Store.class,
        User.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public static AppDatabase INSTANCE;

    public abstract OrderDAO orderDAO();
    public abstract ProductDAO productDAO();
    public abstract StoreDAO storeDAO();
    public abstract UserDAO userDAO();
    public static AppDatabase getInstance(Context context, String dbName, boolean forceOpen) {
        if (null == INSTANCE) {
            INSTANCE = buildDatabaseInstance(context,dbName,forceOpen);
        }
        return INSTANCE;
    }

    /* made public and added ability to pass dbname and also boolean to force open or not */
    public static AppDatabase buildDatabaseInstance(Context context, String dbName, boolean forceOpen) {

        AppDatabase db = Room.databaseBuilder(context,
                        AppDatabase.class,
                        dbName)
                /* ADDED callbacks to allow open and create to be logged */
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Log.d(TAG,"OnCreate callback invoked for " + dbName);
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);
                        Log.d(TAG,"onOpen callback invoked for " + dbName);
                    }

                    @Override
                    public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                        super.onDestructiveMigration(db);
                    }
                })
                .allowMainThreadQueries().build();
        if (forceOpen) {
            db.getOpenHelper().getWritableDatabase();
        }

        return db;
    }

    /* Placed in here to keep everything together */
    /* Slightly modified and made public */
    public static String doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        String path = dbFile.getAbsolutePath();
        return String.valueOf(dbFile.exists());
    }

    /* Will close DB if it is open */
    public void cleanUp(){
        if (INSTANCE != null && INSTANCE.isOpen()) {
            INSTANCE.close();
        }
        INSTANCE = null;
    }


}
