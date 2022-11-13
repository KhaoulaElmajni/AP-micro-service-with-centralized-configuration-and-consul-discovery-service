package me.elmajni.orderservice.web;

import me.elmajni.orderservice.OrderServiceApplication;
import me.elmajni.orderservice.entities.Order;
import me.elmajni.orderservice.models.Customer;
import me.elmajni.orderservice.models.Product;
import me.elmajni.orderservice.repositories.OrderRepository;
import me.elmajni.orderservice.repositories.ProductItemRepository;
import me.elmajni.orderservice.services.CustomerRestClientService;
import me.elmajni.orderservice.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/api")
public class OrderRestController {
    private static final Logger LOG = Logger.getLogger(OrderServiceApplication.class.getName());

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OrderRestController(OrderRepository orderRepository,
                               ProductItemRepository productItemRepository,
                               CustomerRestClientService customerRestClientService,
                               InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        LOG.log(Level.INFO, "Index API is calling");
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.customerById(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }
}
