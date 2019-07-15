package pl.coderslab.entity.eventType;


import pl.coderslab.entity.Event;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("concert")
public class Concert extends Event {

}
