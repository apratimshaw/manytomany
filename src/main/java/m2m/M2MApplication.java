package m2m;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import m2m.entities.Component;
import m2m.entities.Product;
import m2m.repos.ProductRepository;

@SpringBootApplication
public class M2MApplication {

	public static void main(String[] args) {
		SpringApplication.run(M2MApplication.class, args);
	}

	/**
	 * Read JSON and write to DB at startup
	 */
	@Bean
	@Transactional
	CommandLineRunner runner(ProductRepository productRepository) {
		return args -> {
			try {
				Product car = new Product("134245245", "Car", "auto");
				List<Component> components = new ArrayList<>();
				Component engine = new Component("Engine", "4T");
				components.add(engine);
				Component key = new Component("Key", "metal key");
				components.add(key);
				car.setComponents(components);
				productRepository.save(car);
				Product lock = new Product("12345245", "Lock", "padlock");
				List<Component> accessories = new ArrayList<>();
				lock.setComponents(accessories);
				productRepository.save(lock);
				accessories.add(key);
				lock.setComponents(accessories);
				productRepository.save(lock);
			} catch (Exception e) {
				throw new RuntimeException("Error reading json and writing to db", e);
			}
		};
	}
}
