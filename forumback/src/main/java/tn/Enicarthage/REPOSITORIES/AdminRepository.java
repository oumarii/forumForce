package tn.Enicarthage.REPOSITORIES;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
