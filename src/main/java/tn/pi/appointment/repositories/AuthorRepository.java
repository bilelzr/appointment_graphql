package tn.pi.appointment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.appointment.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
