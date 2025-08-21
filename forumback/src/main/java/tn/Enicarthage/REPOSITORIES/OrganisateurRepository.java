package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Enicarthage.ENTITIES.Organisateur;

@Repository
public interface OrganisateurRepository extends JpaRepository<Organisateur, Long> {
}
