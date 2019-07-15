package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
