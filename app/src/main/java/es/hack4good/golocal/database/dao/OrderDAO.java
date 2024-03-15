package es.hack4good.golocal.database.dao;

import androidx.room.Query;

import java.util.List;

import es.hack4good.golocal.database.entity.Order;

public interface OrderDAO {
    @Query("SELECT * FROM order")
    public List<Order> getAllOrders();
    @Query("SELECT * FROM order WHERE id = :id")
    public Order getOrderById(long id);

}
