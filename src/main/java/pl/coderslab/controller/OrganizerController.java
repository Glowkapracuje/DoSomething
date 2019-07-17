package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Event;
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

    @GetMapping("/edit/{id}")
    public String editConcert(@PathVariable Long id, Model model) {

        Event event = eventRepository.findOne(id);

        if(event.getTypeOfEvent().equals("concert")){
            Concert concert = eventRepository.findOne(id);
            model.addAttribute("concert", concert);
            return "/organizer/concertForm";

        } else if(event.getTypeOfEvent().equals("dance")){
            Dance dance = (Dance) eventRepository.findOne(id);
            model.addAttribute("dance", dance);
            return "/organizer/danceForm";

        } else if(event.getTypeOfEvent().equals("trip")){
            Trip trip = (Trip) eventRepository.findOne(id);
            model.addAttribute("trip", trip);
            return "/organizer/tripForm";

        } else if(event.getTypeOfEvent().equals("meeting")){
            Meeting meeting = (Meeting) eventRepository.findOne(id);
            model.addAttribute("meeting", meeting);
            return "/organizer/meetingForm";
        }
        return "/organizer/concertForm";
    }

    @PostMapping("/edit/{id}")
    public String postEditConcert(@Valid Event event, @PathVariable Long id, BindingResult result, HttpSession session) {

        if(result.hasErrors()) {
            return "/organizer/concertForm";
        }

        if(event.getTypeOfEvent().equals("concert")) {
            Long concertId = (Long) session.getAttribute("id");
            Concert concert = (Concert) event;
            concert.setOrganizer(organizerRepository.findOne(concertId));
            eventRepository.save(concert);
        } else if(event.getTypeOfEvent().equals("dance")) {
            Long danceId = (Long) session.getAttribute("id");
            Dance dance = (Dance) event;
            dance.setOrganizer(organizerRepository.findOne(danceId));
            eventRepository.save(dance);
        } else if(event.getTypeOfEvent().equals("meeting")) {
            Long meetingId = (Long) session.getAttribute("id");
            Meeting meeting = (Meeting) event;
            meeting.setOrganizer(organizerRepository.findOne(meetingId));
            eventRepository.save(meeting);
        } else if(event.getTypeOfEvent().equals("trip")) {
            Long tripId = (Long) session.getAttribute("id");
            Trip trip = (Trip) event;
            trip.setOrganizer(organizerRepository.findOne(tripId));
            eventRepository.save(trip);
        }
        return "redirect:../yourEvents";
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

//    @GetMapping("/edit/{id}")
//    public String editDancing(@PathVariable Long id, Model model) {
//
//        Event event = eventRepository.findOne(id);
//        model.addAttribute("dance", event);
//        return "/organizer/danceForm";
//    }

//    @PostMapping("/edit/{id}")
//    public String postEditDancing(@Valid Dance dance, @PathVariable Long id, BindingResult result, HttpSession session) {
//
//        if(result.hasErrors()) {
//            return "/organizer/danceForm";
//        }
//        Long danceId = (Long) session.getAttribute("id");
//        dance.setOrganizer(organizerRepository.findOne(danceId));
//        eventRepository.save(dance);
//        return "redirect:../yourEvents";
//    }
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
//
//    @GetMapping("/edit/{id}")
//    public String editMeeting(@PathVariable Long id, Model model) {
//
//        Event event = eventRepository.findOne(id);
//        model.addAttribute("meeting", event);
//        return "/organizer/meetingForm";
//    }

//    @PostMapping("/edit/{id}")
//    public String postEditMeeting(@Valid Meeting meeting, @PathVariable Long id, BindingResult result, HttpSession session) {
//
//        if(result.hasErrors()) {
//            return "/organizer/meetingForm";
//        }
//        Long meetingId = (Long) session.getAttribute("id");
//        meeting.setOrganizer(organizerRepository.findOne(meetingId));
//        eventRepository.save(meeting);
//
//        return "redirect:../yourEvents";
//    }
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
//
//    @GetMapping("/edit/{id}")
//    public String editTrip(@PathVariable Long id, Model model) {
//
//        Event event = eventRepository.findOne(id);
//        model.addAttribute("trip", event);
//        return "/organizer/tripForm";
//    }

//    @PostMapping("/edit/{id}")
//    public String postEditTrip(@Valid Trip trip, @PathVariable Long id, BindingResult result, HttpSession session) {
//
//        if(result.hasErrors()) {
//            return "/organizer/tripForm";
//        }
//        Long tripId = (Long) session.getAttribute("id");
//        trip.setOrganizer(organizerRepository.findOne(tripId));
//        eventRepository.save(trip);
//
//        return "redirect:../yourEvents";
//    }
//////////////////////////////////////////
//---------------------------------//////

    @GetMapping("/yourEvents")
    public String showTabOfEvents(Model model,HttpSession session) {

        Long id = (Long) session.getAttribute("id");
        model.addAttribute("events", eventRepository.findByOrganizerId(id));

        return "/organizer/yourEvents";
    }




}
