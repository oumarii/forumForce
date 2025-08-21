package tn.Enicarthage.REPOSITORIES;

import tn.Enicarthage.ENTITIES.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
