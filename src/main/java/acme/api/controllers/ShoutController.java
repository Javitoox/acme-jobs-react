package acme.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acme.api.services.ShoutService;
import acme.entities.shouts.Shout;
import acme.framework.controllers.MasterController;

@CrossOrigin(origins = MasterController.BASE_URL)
@RestController
@RequestMapping("/api/shout")
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
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@Valid @RequestBody final Shout shout, final BindingResult result) {
		if (result.hasErrors()) {
			final List<FieldError> errors = new ArrayList<>();
			if (result.hasErrors()) {
				errors.addAll(result.getFieldErrors());
			}
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		} else {
			this.shoutService.save(shout);
			return new ResponseEntity<>("Successful creation", HttpStatus.CREATED);
		}
	}

}