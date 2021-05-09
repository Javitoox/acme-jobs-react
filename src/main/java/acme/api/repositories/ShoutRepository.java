package acme.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import acme.entities.shouts.Shout;

public interface ShoutRepository extends CrudRepository<Shout, Integer>{

	@Query("SELECT s FROM Shout s")
	public List<Shout> findAllShouts();
	
}