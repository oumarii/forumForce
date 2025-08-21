package tn.Enicarthage.REPOSITORIES;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Comite;


@Repository
public interface ComiteRepo extends CrudRepository<Comite, Long> {
	
}

  