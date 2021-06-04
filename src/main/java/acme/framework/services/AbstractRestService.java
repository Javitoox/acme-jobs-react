package acme.framework.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Service;

@Service
@Transactional(TxType.MANDATORY)
public interface AbstractRestService<E> {

	List<E> getAll();
	
	void save(final E entity);

}
