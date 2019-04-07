package etech.admin.domain;


import javax.persistence.*;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="ROLES")
public class Role extends DefaultEntity {

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private List<RolePrivilege> Privileges;

    public Role() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RolePrivilege> getPrivileges() {
        return Privileges;
    }

    public void setPrivileges(List<RolePrivilege> privileges) {
        Privileges = privileges;
    }
}
