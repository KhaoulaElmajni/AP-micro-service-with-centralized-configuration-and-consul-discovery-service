package me.elmajni.inventoryservice;

import me.elmajni.inventoryservice.entities.Product;
import me.elmajni.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {

			Random random = new Random();
			for (int i = 1; i < 10; i++) {
				productRepository.saveAll(List.of(
						Product.builder()
								.name("computer "+i)
								.price(1200+Math.random()*10000)
								.quantity(1+random.nextInt()*1000)
								.build()
				));
			}
		};
	}
}
