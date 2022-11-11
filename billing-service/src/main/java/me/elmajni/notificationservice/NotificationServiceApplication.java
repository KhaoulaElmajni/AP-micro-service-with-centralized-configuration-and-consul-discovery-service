package me.elmajni.notificationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;

import java.util.Map;

@SpringBootApplication
public class NotificationServiceApplication {
	@Autowired
	private VaultTemplate vaultTemplate;

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return args -> {
		vaultTemplate
				.opsForVersionedKeyValue("secret")
				.put("keypair", Map.of("privKey","123456","pubKey","123456"));
		};
	}
}
