package acme.features.api.anonymous.shout;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.entities.shouts.Shout;

@Service
public class ApiAnonymousShoutService {
	
	private final ApiAnonymousShoutRepository repository;

	@Autowired
	public ApiAnonymousShoutService(final ApiAnonymousShoutRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public List<Shout> getAll() throws DataAccessException {
		return this.repository.findAllShouts();
	}
	
	@Transactional(readOnly = false)
	public void save(final Shout shout) throws DataAccessException {
		shout.setMoment(new Date());
		this.repository.save(shout);
	}

}