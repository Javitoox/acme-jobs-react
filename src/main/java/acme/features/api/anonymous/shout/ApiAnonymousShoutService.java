package acme.features.api.anonymous.shout;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.framework.services.AbstractRestService;

@Service
public class ApiAnonymousShoutService implements AbstractRestService<Shout>{
	
	private final ApiAnonymousShoutRepository repository;

	@Autowired
	public ApiAnonymousShoutService(final ApiAnonymousShoutRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Shout> getAll() {
		return this.repository.findAllShouts();
	}
	
	@Override
	public void save(final Shout shout) {
		shout.setMoment(new Date());
		this.repository.save(shout);
	}

}