package m2m.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import m2m.entities.Component;

@RepositoryRestResource(collectionResourceRel = "components", path = "components")
public interface ComponentRepository extends CrudRepository<Component, Long> {
	List<Component> findById(long id);
}
