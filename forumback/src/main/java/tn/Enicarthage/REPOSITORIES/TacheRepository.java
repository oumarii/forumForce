package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
}
