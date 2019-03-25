package etech.admin.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="GROUPS")
public class Group {

    @Id
    private String code;
    private String name;
    private String description;
    private boolean enabled;

    public Group() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
