package pl.coderslab.entity.eventType;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.entity.Event;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("meeting")
public class Meeting extends Event {


    @NotBlank
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
