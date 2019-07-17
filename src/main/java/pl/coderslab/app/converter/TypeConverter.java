package pl.coderslab.app.converter;

import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Event;
import pl.coderslab.entity.eventType.Concert;
import pl.coderslab.entity.eventType.Dance;
import pl.coderslab.entity.eventType.Meeting;
import pl.coderslab.entity.eventType.Trip;

import java.awt.*;

public class TypeConverter implements Converter<String, Event> {
    @Override
    public Event convert(String s) {
        if("concert".equalsIgnoreCase(s)){
            return new Concert();
        }
        if("dance".equalsIgnoreCase(s)) {
            return new Dance();
        }
        if("trip".equalsIgnoreCase(s)) {
            return new Trip();
        }
        if("meeting".equalsIgnoreCase(s)) {
            return new Meeting();
        }
        return new Meeting();
    }
}
