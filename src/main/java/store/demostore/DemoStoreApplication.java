package store.demostore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoStoreApplication.class, args);
		System.out.println("Cargado y listo ");
	}
	// <dependency>
	// <groupId>com.mysql</groupId>
	// <artifactId>mysql-connector-j</artifactId>
	// <scope>runtime</scope>
	// </dependency>
}
