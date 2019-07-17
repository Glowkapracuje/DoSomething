package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Organizer;
import pl.coderslab.entity.eventType.Concert;
import pl.coderslab.entity.eventType.Dance;
import pl.coderslab.entity.eventType.Meeting;
import pl.coderslab.entity.eventType.Trip;
import pl.coderslab.repository.EventRepository;
import pl.coderslab.repository.OrganizerRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {


    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;

    @GetMapping("/chooseType")
    public String addEvent() {
        return "/organizer/type";
    }


//////////////////////////////////
////---------------------////////
    @GetMapping("/concertForm")
    public String makeConcert(Model model) {
        Concert concert = new Concert();
        concert.setTypeOfEvent("concert");
        model.addAttribute(concert);
        return "/organizer/concertForm";
    }

    @PostMapping("/concertForm")
    public String postMakeConcert(@Valid Concert concert, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "/organizer/concertForm";
        }
        Long id = (Long) session.getAttribute("id");
        Organizer organizer = organizerRepository.findOne(id);
        concert.setOrganizer(organizer);
        eventRepository.save(concert);
        return "redirect:yourEvents";
    }
//////////////////////////////////
    @GetMapping("/danceForm")
    public String makeDancing(Model model) {
        Dance dance = new Dance();
        dance.setTypeOfEvent("dance");
        model.addAttribute(dance);
        return "/organizer/danceForm";
    }

    @PostMapping("/danceForm")
    public String postMakeDancing(@Valid Dance dance, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "/organizer/danceForm";
        }
        Long id = (Long) session.getAttribute("id");
        Organizer organizer = organizerRepository.findOne(id);
        dance.setOrganizer(organizer);
        eventRepository.save(dance);
        return "redirect:yourEvents";
    }
///////////////////////////
    @GetMapping("/meetingForm")
    public String makeMeeting(Model model) {
        Meeting meeting = new Meeting();
        meeting.setTypeOfEvent("meeting");
        model.addAttribute(meeting);
        return "/organizer/meetingForm";
    }

    @PostMapping("/meetingForm")
    public String postMakeMeeting(@Valid Meeting meeting, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "/organizer/meetingForm";
        }
        Long id = (Long) session.getAttribute("id");
        Organizer organizer = organizerRepository.findOne(id);
        meeting.setOrganizer(organizer);
        eventRepository.save(meeting);
        return "redirect:yourEvents";
    }
///////////////////////////////////
    @GetMapping("/tripForm")
    public String makeTrip(Model model) {
        Trip trip = new Trip();
        trip.setTypeOfEvent("trip");
        model.addAttribute(trip);
        return "/organizer/tripForm";
    }

    @PostMapping("/tripForm")
    public String postMakeTrip(@Valid Trip trip, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "/organizer/tripForm";
        }

        Long id = (Long) session.getAttribute("id");
        Organizer organizer = organizerRepository.findOne(id);
        trip.setOrganizer(organizer);
        eventRepository.save(trip);
        return "redirect:yourEvents";
    }
//////////////////////////////////////////
//---------------------------------//////

    @GetMapping("/yourEvents")
    public String showTabOfEvents(Model model,HttpSession session) {

        Long id = (Long) session.getAttribute("id");
        model.addAttribute("events", eventRepository.findByOrganizerId(id));

        return "/organizer/yourEvents";
    }



}
