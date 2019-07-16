package pl.coderslab.entity;


import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="event")
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotBlank
    private String place;

    @Column(name="howManyGuests")
    private Integer howManyGuests;

    @ManyToOne
    private Organizer organizer;

    @ManyToMany
    private List<Participant> participantList;

    private String description;

    @NotBlank
    private String typeOfEvent;

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public Integer getHowManyGuests() {
        return howManyGuests;
    }

    public void setHowManyGuests(Integer howManyGuests) {
        this.howManyGuests = howManyGuests;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<Participant> participantList) {
        this.participantList = participantList;
    }

    //    Rodzaj eventu: jubileusz
//    Miejsce: Polanka Redłowska, Gdynia
//    Ilość Osób: 360
//    Klient: MSC Poland sp. z. o.o.

}
