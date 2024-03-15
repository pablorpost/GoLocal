package es.hack4good.golocal.repositories;

import java.util.List;

import es.hack4good.golocal.database.entity.Order;

public interface OrderRepository {
    List<Order> getAllOrders();
    Order getOrderById(long id);
    void insertOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(Order order);
}
