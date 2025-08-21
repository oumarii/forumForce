package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
