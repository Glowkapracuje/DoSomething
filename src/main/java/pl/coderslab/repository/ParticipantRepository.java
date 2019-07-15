package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}


//czy dla kazdej podklasy nalezy tworzyc oddzielne repo, pewnie nie
//jak ustawic relacje
