package m2m.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import m2m.entities.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findById(long id);
}
