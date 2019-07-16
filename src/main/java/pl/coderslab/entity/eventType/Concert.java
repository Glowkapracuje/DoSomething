package pl.coderslab.entity.eventType;


import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.entity.Event;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("concert")
public class Concert extends Event {


    private String band;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }
}
