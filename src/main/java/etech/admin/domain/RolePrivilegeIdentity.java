package etech.admin.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class RolePrivilegeIdentity implements Serializable {


    @Column(name = "roleId")
    private int roleId;
    @Column(name = "privilegesId")
    private int privilegesId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPrivilegesId() {
        return privilegesId;
    }

    public void setPrivilegesId(int privilegesId) {
        this.privilegesId = privilegesId;
    }
}