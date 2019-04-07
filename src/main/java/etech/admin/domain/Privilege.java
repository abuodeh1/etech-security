package etech.admin.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="PRIVILEGES")
public class Privilege extends DefaultEntity {

    private String description;

    public Privilege() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
