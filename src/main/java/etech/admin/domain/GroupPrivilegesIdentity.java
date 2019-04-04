package etech.admin.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class GroupPrivilegesIdentity implements Serializable {

    @Column(name = "groupId")
    private int groupId;
    @Column(name = "privilegesId")
    private int privilegesId;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getPrivilegesId() {
        return privilegesId;
    }

    public void setPrivilegesId(int privilegesId) {
        this.privilegesId = privilegesId;
    }

}
