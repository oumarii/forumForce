package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Long> {

}
