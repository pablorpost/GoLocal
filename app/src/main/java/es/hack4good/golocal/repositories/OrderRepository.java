package es.hack4good.golocal.repositories;

import java.util.HashMap;
import java.util.List;

import es.hack4good.golocal.database.entity.Order;

public class OrderRepository {
    private HashMap<Long, Order> orders;

    public OrderRepository() {
        orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Order findById(long id) {
        return orders.get(id);
    }

    public List<Order> findAll() {
        return (List<Order>) orders.values();
    }


}
