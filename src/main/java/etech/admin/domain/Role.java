package etech.admin.domain;


import javax.persistence.*;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="ROLES")
public class Role extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String code;
    private String name;
    private String description;
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId")
    private List<RolePrivilege> Privileges;

    public Role() {
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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

    /*public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }*/

    @Override
    public int getId() {
        return this.roleId;
    }

    @Override
    public void setId(int id) {
        this.roleId = id;
    }

    /*public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }*/

    public List<RolePrivilege> getPrivileges() {
        return Privileges;
    }

    public void setPrivileges(List<RolePrivilege> privileges) {
        this.Privileges = privileges;
    }
}
