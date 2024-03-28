package tn.pi.appointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.appointment.entities.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
