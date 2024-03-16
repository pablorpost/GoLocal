package es.hack4good.golocal;
import android.app.Application;
import androidx.room.Room;

import es.hack4good.golocal.database.AppDatabase;

public class MyApplication extends Application{

    private AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getInstance(this);
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }
}


