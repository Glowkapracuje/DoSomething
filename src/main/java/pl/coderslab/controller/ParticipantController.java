package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.Participant;
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

    @GetMapping("/join")
    @ResponseBody
    public String joinToEvent() {
      //  Event event = eventRepository.getOne(id);
        return "Elo";
    }


//    @GetMapping("/yourEvents")
//    public String showYourEvents() {
//        List<Event> events = participantRepository.
//        return "/participant/yourEvents";
//    }




}
