package acme.api.controllers;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acme.api.services.ShoutService;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/shout")
public class ShoutController implements ApplicationContextAware {

	// Internal state ---------------------------------------------------------

	protected ConfigurableApplicationContext context;
	
	@Autowired
	protected ShoutService	shoutService;

	// ApplicationContextAware interface --------------------------------------

	@Override
	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		assert context != null;

		this.context = (ConfigurableApplicationContext) context;
	}

	@GetMapping
	public ResponseEntity<?> list() {
		return ResponseEntity.ok(this.shoutService.getAll());
	}

}