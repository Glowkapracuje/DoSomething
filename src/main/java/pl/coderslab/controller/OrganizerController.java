package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.eventType.Concert;
import pl.coderslab.entity.eventType.Dance;
import pl.coderslab.entity.eventType.Meeting;
import pl.coderslab.entity.eventType.Trip;
import pl.coderslab.repository.EventRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/organizers")
public class OrganizerController {


    @Autowired
    EventRepository eventRepository;

    @GetMapping("/chooseType")
    public String addEvent() {
        return "/organizer/type";
    }
//////////////////////////////////
    @GetMapping("/concertForm")
    public String makeConcert(Model model) {
        Concert concert = new Concert();
        concert.setTypeOfEvent("concert");
        model.addAttribute(concert);
        return "/organizer/concertForm";
    }

    @PostMapping("/concertForm")
    public String postMakeConcert(@Valid Concert concert, BindingResult result) {

        if(result.hasErrors()) {
            return "/organizer/concertForm";
        }
        eventRepository.save(concert);
        return "/organizer/yourEvents";
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
    public String postMakeDancing(@Valid Dance dance, BindingResult result) {

        if(result.hasErrors()) {
            return "/organizer/danceForm";
        }
        eventRepository.save(dance);
        return "/organizer/yourEvents";
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
    public String postMakeMeeting(@Valid Meeting meeting, BindingResult result) {

        if(result.hasErrors()) {
            return "/organizer/meetingForm";
        }
        eventRepository.save(meeting);
        return "/organizer/yourEvents";
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
    public String postMakeTrip(@Valid Trip trip, BindingResult result) {

        if(result.hasErrors()) {
            return "/organizer/tripForm";
        }
        eventRepository.save(trip);
        return "/organizer/yourEvents";
    }
//////////////////////////////////////////
//??????????????????
    @GetMapping("/yourEvents")
    public String showTabOfEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "/participant/events";
    }



}
