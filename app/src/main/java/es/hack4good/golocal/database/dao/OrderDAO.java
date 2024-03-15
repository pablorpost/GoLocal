package es.hack4good.golocal.database.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import es.hack4good.golocal.database.entity.Order;

public interface OrderDAO {
    @Query("SELECT * FROM order")
    public List<Order> getAllOrders();
    @Query("SELECT * FROM order WHERE id = :id")
    public Order getOrderById(long id);

    @Insert
    public void insertOrder(Order order);
    @Update
    public void updateOrder(Order order);
    @Delete
    public void deleteOrder(Order order);

}
