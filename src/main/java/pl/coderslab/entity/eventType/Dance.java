package pl.coderslab.entity.eventType;


import pl.coderslab.entity.Event;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dance")
public class Dance extends Event {
}
