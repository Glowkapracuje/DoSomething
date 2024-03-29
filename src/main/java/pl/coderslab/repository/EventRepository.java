package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {


    List<Event> findByParticipantListId(Long id);
    List<Event> findByOrganizerId(Long id);


}
