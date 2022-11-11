package me.elmajni.orderservice.entities;

import me.elmajni.orderservice.enums.OrderStatus;
import me.elmajni.orderservice.models.Customer;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullOrder",types = Order.class)
public interface OrderProjection {
    Long getId();
    Date getCreatedAt();
    OrderStatus getStatus();
    Long getCustomerId();
}
