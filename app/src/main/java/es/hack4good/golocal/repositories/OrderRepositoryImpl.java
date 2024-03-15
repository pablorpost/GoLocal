package es.hack4good.golocal.repositories;

import es.hack4good.golocal.database.dao.OrderDAO;
import es.hack4good.golocal.database.entity.Order;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    private OrderDAO orderDAO;
    public OrderRepositoryImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    public Order getOrderById(long id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    public void insertOrder(Order order) {
        orderDAO.insertOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderDAO.deleteOrder(order);
    }

}
