package es.hack4good.golocal.backend;

import es.hack4good.golocal.repositories.OrderRepository;
import es.hack4good.golocal.repositories.ProductRepository;
import es.hack4good.golocal.services.OrderService;
import es.hack4good.golocal.services.ProductService;

public class Persistent {
    private static OrderRepository orderRepository = new OrderRepository();
    private static ProductRepository productRepository = new ProductRepository();

    public Persistent() {

    }


}
