package etech.admin.domain;

import javax.persistence.*;
import java.util.List;

//@Audited
//@EntityListeners(AuditingEntityListener.class)
@Entity(name="GROUPS")
public class Group extends DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupId;

    private String code;
    private String name;
    private String description;
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private List<GroupRole> roles;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
    private List<GroupPrivileges> privileges;



    public Group() {
    }

    public Group(String code, String name) {
        this.code = code;
        this.name = name;
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

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public int getId() {
        return groupId;
    }

    @Override
    public void setId(int id) {
        this.groupId = id;
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
