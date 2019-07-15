package pl.coderslab.entity.eventType;


import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.entity.Event;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("dance")
public class Dance extends Event {

    @NotBlank
    private String typeOfDance;

    @NotBlank
    private String typeOfDress;

    public String getTypeOfDance() {
        return typeOfDance;
    }

    public void setTypeOfDance(String typeOfDance) {
        this.typeOfDance = typeOfDance;
    }

    public String getTypeOfDress() {
        return typeOfDress;
    }

    public void setTypeOfDress(String typeOfDress) {
        this.typeOfDress = typeOfDress;
    }
}
