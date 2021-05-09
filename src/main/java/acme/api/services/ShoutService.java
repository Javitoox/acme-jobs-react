package acme.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.api.repositories.ShoutRepository;
import acme.entities.shouts.Shout;

@Service
public class ShoutService {
	
	private final ShoutRepository repository;

	@Autowired
	public ShoutService(final ShoutRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<Shout> getAll() throws DataAccessException {
		return this.repository.findAllShouts();
	}

}