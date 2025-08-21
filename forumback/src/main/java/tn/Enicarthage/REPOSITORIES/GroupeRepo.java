package tn.Enicarthage.REPOSITORIES;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Groupe;



@Repository
public interface GroupeRepo  extends CrudRepository<Groupe, Long> {
	
}
