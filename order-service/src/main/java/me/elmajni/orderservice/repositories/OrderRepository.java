package me.elmajni.orderservice.repositories;

import me.elmajni.orderservice.entities.Order;
import me.elmajni.orderservice.entities.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order,Long> {

}
