package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Event;
import pl.coderslab.repository.EventRepository;
import pl.coderslab.repository.ParticipantRepository;

import java.util.List;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/events")
    public String showTabOfEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "/participant/events";
    }



//    @GetMapping("/yourEvents")
//    public String showYourEvents() {
//        List<Event> events = participantRepository.
//        return "/participant/yourEvents";
//    }

//    @PostMapping("/join")
//    public String joinToEvent() {
//        return
//    }




}
