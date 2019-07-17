package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.Participant;
import pl.coderslab.repository.EventRepository;
import pl.coderslab.repository.ParticipantRepository;

import javax.servlet.http.HttpSession;
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

    @GetMapping("/join/{id}")
    @ResponseBody
    public String joinToEvent(@PathVariable Long id,
                              HttpSession session) {

        Long participantId = (Long) session.getAttribute("id");
        System.out.println(participantId);
        return "elo";
//        Event event = eventRepository.getOne(id);
//        event.getParticipantList().add();

    }


//    @GetMapping("/yourEvents")
//    public String showYourEvents() {
//        List<Event> events = participantRepository.
//        return "/participant/yourEvents";
//    }




}
