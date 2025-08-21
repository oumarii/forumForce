package tn.Enicarthage.REPOSITORIES;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Personne;

import java.util.List;

@Repository
public interface PersonneRepository extends CrudRepository<Personne, Long> {

}
