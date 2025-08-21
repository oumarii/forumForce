package tn.Enicarthage.REPOSITORIES;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.Enicarthage.ENTITIES.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
