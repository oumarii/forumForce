package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Depense;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Integer> {
}
