package etech.admin.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ROLES")
public class Role {

    @Id
    private String code;
    private String name;
    private String description;
    private boolean enabled;

    public Role() {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}