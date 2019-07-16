package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.coderslab.repository.EventRepository;
import pl.coderslab.repository.OrganizerRepository;
import pl.coderslab.repository.ParticipantRepository;

@Controller
public class LoginController {

    private OrganizerRepository organizerRepository;

    @Autowired
    public LoginController(OrganizerRepository organizerRepository) {
        this.organizerRepository = organizerRepository;
    }


}
