package me.elmajni.orderservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.elmajni.orderservice.enums.OrderStatus;
import me.elmajni.orderservice.models.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;


    public double getTotal(){
        return productItems.stream()
                .mapToDouble(ProductItem::getTotal).sum();
    }

}
