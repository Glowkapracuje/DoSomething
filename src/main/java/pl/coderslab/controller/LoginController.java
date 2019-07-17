package pl.coderslab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Organizer;
import pl.coderslab.entity.Participant;
import pl.coderslab.repository.EventRepository;
import pl.coderslab.repository.OrganizerRepository;
import pl.coderslab.repository.ParticipantRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private OrganizerRepository organizerRepository;
    private ParticipantRepository participantRepository;



    @Autowired
    public LoginController(OrganizerRepository organizerRepository, ParticipantRepository participantRepository) {
        this.organizerRepository = organizerRepository;
        this.participantRepository = participantRepository;
    }

    @GetMapping("/login/organizer/register")
    public String registerOrganizer(Model model) {
        model.addAttribute("organizer", new Organizer());
        return "/login/organizer/register";
    }

    @PostMapping("/login/organizer/register")
    public String postRegisterOrganizer(@Valid Organizer organizer, BindingResult bindingResult, @RequestParam String confirmPassword) {

        if(bindingResult.hasErrors()) {
            return "/login/organizer/register";
        }
        if(!organizer.getPassword().equals(confirmPassword)) {
            bindingResult.addError(new FieldError("organizer", "password", "Hasla nie zgadzaja sie"));
            return "login/organizer/register";
        }
        if(organizerRepository.getByEmail(organizer.getEmail()) != null) {
            bindingResult.addError(new FieldError("organizer", "email", "Organizer already exists"));
            return "/login/organizer/register";
        }

        organizerRepository.save(organizer);
        return "redirect:/login/organizer/login";

    }

    @GetMapping("/login/organizer/login")
    public String loginOrganizer() {
        return "/login/organizer/login";
    }

    @PostMapping("/login/organizer/login")
    public String postLoginOrganizer(@RequestParam String email,
                                     @RequestParam String password,
                                     Model model, HttpServletRequest request) {
        boolean success = true;
        if(email == null || password == null || email.trim().equals("") || password.trim().equals("")) {
            success=false;
        }

        Organizer existingOrganizer = null;
        if(success) {
            existingOrganizer = organizerRepository.getByEmail(email);
            if(existingOrganizer == null || !existingOrganizer.getPassword().equals(password)) {
                success=false;
            }
        }

        model.addAttribute("success", success);

        if(!success) {
            model.addAttribute("success", false);
            return "/login/organizer/login";
        }

        HttpSession session = request.getSession();

        session.setAttribute("email", email);
        session.setAttribute("name", existingOrganizer.getName());
        session.setAttribute("id", existingOrganizer.getId());

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String organizerLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/login/participant/register")
    public String registerParticipant(Model model) {
        model.addAttribute("participant", new Participant());
        return "login/participant/register";
    }

    @PostMapping("/login/participant/register")
    public String postRegisterParticipant(@Valid Participant participant, BindingResult bindingResult, @RequestParam String confirmPassword) {

        if(bindingResult.hasErrors()) {
            return "/login/participant/register";
        }
        if(!participant.getPassword().equals(confirmPassword)) {
            bindingResult.addError(new FieldError("participant", "password", "Hasla nie zgadzaja sie"));
            return "login/participant/register";
        }
        if(participantRepository.getByEmail(participant.getEmail()) != null) {
            bindingResult.addError(new FieldError("participant", "email", "Organizer already exists"));
            return "/login/participant/register";
        }

        participantRepository.save(participant);
        return "redirect:/login/participant/login";
    }

    @GetMapping("/login/participant/login")
    public String loginParticipant() {
        return "/login/participant/login";
    }

    @PostMapping("/login/participant/login")
    public String postLoginParticipant(@RequestParam String email,
                                       @RequestParam String password,
                                       Model model, HttpServletRequest request) {
        boolean success = true;
        if(email == null || password == null || email.trim().equals("") || password.trim().equals("")) {
            success=false;
        }

        Participant existingParticipant = null;
        if(success) {
            existingParticipant = participantRepository.getByEmail(email);
            if(existingParticipant == null || !existingParticipant.getPassword().equals(password)) {
                success=false;
            }
        }

        model.addAttribute("success", success);

        if(!success) {
            model.addAttribute("success", false);
            return "/login/participant/login";
        }

        HttpSession session = request.getSession();

        session.setAttribute("email", email);
        session.setAttribute("firstName", existingParticipant.getFirstName());

        return "redirect:/participants/events";
    }
}
