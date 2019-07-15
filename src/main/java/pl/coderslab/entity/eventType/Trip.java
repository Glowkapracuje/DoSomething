package pl.coderslab.entity.eventType;

import pl.coderslab.entity.Event;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("trip")
public class Trip extends Event {



    @NotNull
    private String fromWhere;

    @NotNull
    private String toWhere;

    @Column(name="eq_description")
    private String equipmentDescription;

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getToWhere() {
        return toWhere;
    }

    public void setToWhere(String toWhere) {
        this.toWhere = toWhere;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }
}
