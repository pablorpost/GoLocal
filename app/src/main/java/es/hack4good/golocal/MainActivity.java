package es.hack4good.golocal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import es.hack4good.golocal.database.DB;
import es.hack4good.golocal.database.dao.OrderDAO;
import es.hack4good.golocal.database.dao.ProductDAO;
import es.hack4good.golocal.database.dao.StoreDAO;
import es.hack4good.golocal.database.dao.UserDAO;
import es.hack4good.golocal.repositories.OrderRepository;
import es.hack4good.golocal.repositories.OrderRepositoryImpl;
import es.hack4good.golocal.repositories.ProductRepositoryImpl;
import es.hack4good.golocal.repositories.StoreRepositoryImpl;
import es.hack4good.golocal.repositories.UserRepositoryImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB db = DB.getInstance(this.getApplicationContext());
        OrderDAO orderDAO = db.orderDAO();
        ProductDAO productDAO = db.productDAO();
        StoreDAO storeDAO = db.storeDAO();
        UserDAO userDAO = db.userDAO();
        OrderRepository orderRepository = new OrderRepositoryImpl(orderDAO);
        ProductRepository productRepository = new ProductRepositoryImpl(productDAO);
        StoreRepository storeRepository = new StoreRepositoryImpl(storeDAO);
        UserRepository userRepository = new UserRepositoryImpl(userDAO);
    }

}
