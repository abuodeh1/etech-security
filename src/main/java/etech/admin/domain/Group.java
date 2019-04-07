package etech.admin.domain;

import javax.persistence.*;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPS")
public class Group extends DefaultEntity {


    private String description;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private List<GroupRole> roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private List<GroupPrivileges> privileges;



    public Group() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GroupRole> getRoles() {
        return roles;
    }

    public void setRoles(List<GroupRole> roles) {
        this.roles = roles;
    }

    public List<GroupPrivileges> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<GroupPrivileges> privileges) {
        this.privileges = privileges;
    }
}
