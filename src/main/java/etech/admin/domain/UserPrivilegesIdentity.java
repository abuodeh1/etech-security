package etech.admin.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class UserPrivilegesIdentity implements Serializable {

    @Column(name = "userId")
    private int userId;
    @Column(name = "privilegesId")
    private int privilegesId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrivilegesId() {
        return privilegesId;
    }

    public void setPrivilegesId(int privilegesId) {
        this.privilegesId = privilegesId;
    }
}
