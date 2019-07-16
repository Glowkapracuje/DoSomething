package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.Participant;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Participant getByEmail(String email);
}


//czy dla kazdej podklasy nalezy tworzyc oddzielne repo, pewnie nie
//jak ustawic relacje
