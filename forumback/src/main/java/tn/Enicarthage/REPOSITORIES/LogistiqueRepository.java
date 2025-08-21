package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Logistique;

@Repository
public interface LogistiqueRepository extends JpaRepository<Logistique, Integer> {
}
