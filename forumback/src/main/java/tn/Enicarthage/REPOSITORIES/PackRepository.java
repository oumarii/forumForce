package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.Enicarthage.ENTITIES.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack, Integer> {
}