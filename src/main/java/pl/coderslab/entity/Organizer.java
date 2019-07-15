package pl.coderslab.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "organizer")
public class Organizer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=2, max=60)
    private String name;

    @NotBlank
    private String surname;

    @Email
    private String email;


    private List<Event> eventList;


}
