package me.elmajni.customerservice;

import me.elmajni.customerservice.entities.Customer;
import me.elmajni.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("khaoula").email("elmajnikhaoula99@gmail.com").build(),
					Customer.builder().name("khaoula").email("elmajnikhaoula99@gmail.com").build(),
					Customer.builder().name("khaoula").email("elmajnikhaoula99@gmail.com").build(),
					Customer.builder().name("khaoula").email("elmajnikhaoula99@gmail.com").build(),
					Customer.builder().name("khaoula").email("elmajnikhaoula99@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
