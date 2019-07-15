package pl.coderslab.entity;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="event")
@DiscriminatorColumn(name="event_type",
        discriminatorType = DiscriminatorType.STRING)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Date date;

    @NotBlank
    private String place;

    @NotBlank
    private String typeOfEvent;

    @Column(name="howManyGuests")
    private Integer howManyGuests;

    @OneToOne
    private Organizer organizer;

    @ManyToOne
    private List<Participant> participantList;

    private String description;


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

    public String getTypeOfEvent() {
        return typeOfEvent;
    }

    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
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
